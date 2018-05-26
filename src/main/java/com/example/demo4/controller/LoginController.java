package com.example.demo4.controller;

import com.alibaba.fastjson.JSONObject;
import com.example.demo4.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;



@RestController
@RequestMapping("/login")
public class LoginController {

    @Autowired
    private  LoginService loginService;

    @RequestMapping("/userLogin")
    public JSONObject login(@RequestParam("username")String username, @RequestParam("password")String password, HttpSession session){
         JSONObject object=loginService.commonUserLogin(username,password);
         if("0".equals(String.valueOf(object.get("code")))){
             session.setAttribute("token",String.valueOf(object.get("token")));
             session.setAttribute("username",username);
             session.setAttribute("password",password);
         }
         return object;
    }

    @RequestMapping("/loginExpired")
    public JSONObject loginExpired(){
        System.out.println("login fail");
        JSONObject object=new JSONObject();
        object.put("code",2);
        object.put("msg","Login expired, please log in again");
        return object;
    }

}
