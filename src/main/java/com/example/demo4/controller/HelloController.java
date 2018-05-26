package com.example.demo4.controller;

import com.example.demo4.dao.CityBeanMapper;
import com.example.demo4.domain.CityBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/hello")
public class HelloController {

	@Autowired
	private CityBeanMapper cityBeanMapper;
	@Autowired
	private StringRedisTemplate template;

	@RequestMapping("/11")
	public String hello() {
		template.opsForValue().set("shabao", "我是傻宝2");
		return "Hello World!";
	}

	@RequestMapping("/111")
	public String hello2() {
		String shabao = template.opsForValue().get("shabao");
		return shabao;
	}

	@RequestMapping("/detail/{id}")
	public CityBean findById(@PathVariable Short id) {
		CityBean city = cityBeanMapper.selectByPrimaryKey(id);
		return city;
	}

	@RequestMapping("/all")
	public List<CityBean> findAll() {
		List<CityBean> citys = cityBeanMapper.selectAll();
		return citys;
	}

}
