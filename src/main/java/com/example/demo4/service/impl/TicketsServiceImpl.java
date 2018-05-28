package com.example.demo4.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.example.demo4.dao.TicketsMapper;
import com.example.demo4.domain.TicketsBean;
import com.example.demo4.service.TicketsService;
import com.example.demo4.utils.DataUtil;
import com.google.gson.JsonObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.List;

@Service
public class TicketsServiceImpl implements TicketsService {

    @Autowired
    private TicketsMapper ticketsMapper;

    public JSONObject queryAll(String username){
        System.out.println("查询所有的机票呀"+username);
        JSONObject object=new JSONObject();
        List<TicketsBean> tickets= ticketsMapper.selectAll();
        if(tickets!=null && tickets.size()>0){
            for (TicketsBean ticket:tickets) {
                ticket.setStart_date_string(DataUtil.dateFormat(ticket.getStart_date()));
                ticket.setEnd_date_string(DataUtil.dateFormat(ticket.getEnd_date()));
            }
        }
        object.put("code",0);
        object.put("msg","Success");
        object.put("data",tickets);
        return object;
    }

    public TicketsBean queryById(int id){
        System.out.println("查询一张的机票呀"+id);
        TicketsBean ticket=ticketsMapper.selectById(id);
        return ticket;
    }

    public JSONObject addTicket(TicketsBean ticketsBean) {
        JSONObject object=new JSONObject();
        ticketsBean.setStart_date(DataUtil.string2date(ticketsBean.getStart_date_string()));
        ticketsBean.setEnd_date(DataUtil.string2date(ticketsBean.getEnd_date_string()));
       int exec= ticketsMapper.insert(ticketsBean);
       if(1==exec){
           object.put("code",0);
       }else{
           object.put("code",1);
       }
       return object;
    }
}
