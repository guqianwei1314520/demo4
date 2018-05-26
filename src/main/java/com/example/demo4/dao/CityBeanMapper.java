package com.example.demo4.dao;


import com.example.demo4.domain.CityBean;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface CityBeanMapper {


	@Select("select * from city where city_id=#{id}")
    CityBean selectByPrimaryKey(@Param("id") int id);

    @Select("select * from city")
    List<CityBean> selectAll();


}