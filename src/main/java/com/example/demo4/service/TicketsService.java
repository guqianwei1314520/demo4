package com.example.demo4.service;

import com.alibaba.fastjson.JSONObject;
import com.example.demo4.domain.TicketsBean;
import org.springframework.cache.annotation.Cacheable;

public interface TicketsService {

    @Cacheable(value="tickets")
    public JSONObject queryAll(String username);

    @Cacheable(value="ticket")
    public TicketsBean queryById(int id);

    public JSONObject addTicket(TicketsBean ticketsBean);
}
