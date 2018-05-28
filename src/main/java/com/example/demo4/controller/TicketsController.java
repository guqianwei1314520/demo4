package com.example.demo4.controller;

import com.alibaba.fastjson.JSONObject;
import com.example.demo4.domain.TicketsBean;
import com.example.demo4.service.TicketsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.Date;

@RestController
@RequestMapping("/tickets")
public class TicketsController {

    @Autowired
    private TicketsService ticketsService;

    @RequestMapping("/all")
    public JSONObject getTickets(HttpSession session){
        JSONObject object_tmp=new JSONObject();
        String roleId=String.valueOf(session.getAttribute("roleId"));
        if(!"2".equals(roleId)){
            object_tmp.put("code",2);
            object_tmp.put("msg","No authority");
            return object_tmp;
        }
        JSONObject  object=ticketsService.queryAll(String.valueOf(session.getAttribute("username")));
        object.put("token",session.getAttribute("token"));
        return object;
    }

    @RequestMapping("/ticket/{id}")
    public JSONObject getTicket(@PathVariable int id,HttpSession session){
        JSONObject object=new JSONObject();
        TicketsBean tickets=ticketsService.queryById(id);
        object.put("code",0);
        object.put("data",tickets);

        return object;
    }

    @RequestMapping("/add")
    public JSONObject addTicket(TicketsBean ticketsBean,HttpSession session){
        JSONObject object=new JSONObject();
        String roleId=String.valueOf(session.getAttribute("roleId"));
        if(!"1".equals(roleId)){
            object.put("code",2);
            object.put("msg","No authority");
            return object;
        }
        return ticketsService.addTicket(ticketsBean);
    }
}
