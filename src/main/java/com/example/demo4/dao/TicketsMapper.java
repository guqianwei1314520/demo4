package com.example.demo4.dao;

import com.example.demo4.domain.TicketsBean;
import org.apache.ibatis.annotations.Insert;
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

    @Insert("insert into tickets (train,start_date,start_airport,end_date,end_airport,price,airline) values " +
            "(#{train},#{start_date},#{start_airport},#{end_date},#{end_airport},#{price},#{airline})")
    int insert(TicketsBean ticket);
}
