package com.example.demo4.dao;

import com.example.demo4.domain.TicketsBean;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface TicketsMapper {

    @Select("select * from tickets")
    List<TicketsBean> selectAll();

    @Select("select * from tickets where id=#{id}")
    TicketsBean selectById(@Param("id")int id);
}
