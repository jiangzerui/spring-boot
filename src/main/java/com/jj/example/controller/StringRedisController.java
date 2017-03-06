package com.jj.example.controller;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class StringRedisController {
	
	private static Logger logger = LoggerFactory.getLogger(StringRedisController.class);
	
	@Autowired
	StringRedisTemplate stringRedisTemplate;
	
	@Resource(name="stringRedisTemplate")
	ValueOperations<String, String> valueOper;
	
	@RequestMapping("set")
	public String setKeyAndValue(String key, String value){
		logger.debug("访问set:key={}, value={}",key,value);
		valueOper.set(key, value);
		return "OK";
	}
	
	@RequestMapping("get")
	public String getKey(String key){
		logger.debug("访问get:key={}",key);
		return valueOper.get(key);
	}
}
