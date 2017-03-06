package com.jj.example.controller;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@EnableAutoConfiguration
public class HelloController {

	@RequestMapping("/")
	String home(){
		return "hello spring boot";
	}
	
	@RequestMapping("/hello/{myName}")
	String index(@PathVariable String myName){
		return "hello" + myName + "!!!";
	}
}
