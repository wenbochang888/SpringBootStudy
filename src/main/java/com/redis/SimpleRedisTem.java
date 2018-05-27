package com.redis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * 利用SpringBoot自带的RedisTemplate来模拟redis的访问请求
 * RedisTemplate是一个泛型，它可以存放类对象等一些
 * 但要进行配置，默认为JDK自带的序列化，可以改为fastJSON，protostuff等一些
 *
 * @author wenbochang
 * @date 2018年5月27日
 */
@RestController
public class SimpleRedisTem {

	@Autowired
	RedisTemplate<Object, Object> redisTemplate;
	
	
	@RequestMapping(value = "/get/redis", method = RequestMethod.GET)
	public String getRedisData() {
		
		Person person = (Person) redisTemplate.opsForValue().get("zhangsan");
		
		return person.toString();
	}
	
	//获取post传过来的参数
	@RequestMapping(value = "/put/redis", method = RequestMethod.POST)
	public String putRedisData(@Param("name") String name,
			@Param("age") int age) {
		Person person = new Person(name, age);
		redisTemplate.opsForValue().set(name, person);
		System.out.println("name = " + name);
		System.out.println("age = " + age);
		
		return name + ": " + age;
	}
}











