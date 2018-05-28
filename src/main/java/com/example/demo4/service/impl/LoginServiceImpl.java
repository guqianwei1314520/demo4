package com.example.demo4.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.example.demo4.dao.CommonUserBeanMapper;
import com.example.demo4.domain.CommonUserBean;
import com.example.demo4.service.LoginService;
import com.example.demo4.utils.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginServiceImpl implements LoginService {

    @Autowired
    public CommonUserBeanMapper commonUserBeanMapper;

    @Override
    public JSONObject commonUserLogin(String username, String password) {
        JSONObject object=new JSONObject();
        CommonUserBean commonUser=commonUserBeanMapper.selectByUsername(username);
        if(commonUser!=null && commonUser.getPassword()!=null && password.equals(commonUser.getPassword())){
            object.put("code",0);
            object.put("msg","Success");
            String token="";
            try {
                token=JwtUtil.createToken(username,password);
            } catch (Exception e) {

            }
            object.put("token",token);
            object.put("roleId",commonUser.getRole_id());

        }else{
            object.put("code",1);
        }
        return object;
    }
}
