package com.jj.example.domain;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Repository;

@Repository
public class PersonDao {
	
	@Autowired
	RedisTemplate<Object,Object> redisTemplate;
	
	@Resource(name="redisTemplate")
	ValueOperations<Object,Object> valOper;
	
	public void save(Person person){
		valOper.set(person.getId(),person);
	}
	
	public Person getPerson(String id){
		return (Person) valOper.get(id);
	}
	
}
