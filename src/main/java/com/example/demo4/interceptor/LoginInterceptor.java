package com.example.demo4.interceptor;

import com.example.demo4.utils.JwtUtil;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o) throws Exception {
        StringBuffer url=httpServletRequest.getRequestURL();
        if(url.toString().contains("/login/userLogin")){
            return true;
        }

        HttpSession session = httpServletRequest.getSession();
        String token=httpServletRequest.getHeader("token");
        //请求未携带token
        if(token==null || "".equals(token)){
            return false;
        }
        //解密
        String name=null;
        try {
            name=JwtUtil.verifyToken(token);
        }catch (Exception e){
            //token过期TokenExpiredException   com.auth0.jwt.exceptions.JWTDecodeException: The token was expected to have 3 parts, but got 1.
            return false;
        }

        if(token!=null && token.equals(session.getAttribute("token")) && name!=null && name.equals(session.getAttribute("username"))){
            String newToken="";
            try {
                newToken=JwtUtil.createToken(String.valueOf(session.getAttribute("username")),String.valueOf(session.getAttribute("password")));
            } catch (Exception e) {

            }
            session.setAttribute("token",newToken);
            return true;

        }else{
            //token或者用户名不匹配
            return false;
        }

        /*httpServletRequest.getRequestDispatcher("/login/loginExpired").forward(httpServletRequest,httpServletResponse);*/
        /*httpServletResponse.sendRedirect("/login/loginExpired");*/
    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {
    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {
    }


   /* public void loginInvalid(HttpServletResponse httpServletResponse){
        JSONObject responseDate=new JSONObject();
        responseDate.put("code",2);
        responseDate.put("msg","Login expired, please log in again");
        PrintWriter printWriter = null;
        try {
            printWriter = httpServletResponse.getWriter();
            printWriter.write(responseDate.toJSONString());
        } catch (IOException e) {

        }finally {
            printWriter.flush();
            printWriter.close();
        }
    }*/
}
