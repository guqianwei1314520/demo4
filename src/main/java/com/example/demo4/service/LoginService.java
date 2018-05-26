package com.example.demo4.service;

import com.alibaba.fastjson.JSONObject;
import org.springframework.cache.annotation.CacheEvict;

public interface LoginService {

     @CacheEvict(value="tickets",allEntries=true)
     public JSONObject commonUserLogin(String username, String password);

}
