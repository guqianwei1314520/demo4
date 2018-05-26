package com.example.demo4.dao;


import com.example.demo4.domain.CommonUserBean;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface CommonUserBeanMapper {

    @Select("select * from Common_User where username=#{username}")
    CommonUserBean selectByUsername(@Param("username") String username);
}
