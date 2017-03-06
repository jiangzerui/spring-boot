package com.jj.example.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jj.example.domain.Person;
import com.jj.example.domain.PersonDao;

@RestController
public class PersonController {
	protected static Logger logger=LoggerFactory.getLogger(PersonController.class);  
    
    @Autowired  
    PersonDao personDao;  
      
    @RequestMapping("/setPerson")  
    public void set(String id,String name,Integer age){  
        logger.debug("访问setPerson:id={},name={},age={}",id,name,age);  
        Person person=new Person(id,name,age);  
        personDao.save(person);  
       // return "/";
    }  
      
    @RequestMapping("/getPerson")  
    public Person getPerson(String id){  
        return personDao.getPerson(id);  
    }  
}
