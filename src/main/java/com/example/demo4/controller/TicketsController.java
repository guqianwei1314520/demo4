package com.example.demo4.controller;

import com.alibaba.fastjson.JSONObject;
import com.example.demo4.domain.TicketsBean;
import com.example.demo4.service.TicketsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

@RestController
@RequestMapping("/tickets")
public class TicketsController {

    @Autowired
    private TicketsService ticketsService;

    @RequestMapping("/all")
    public JSONObject getTickets(HttpSession session){
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
}
