package com.redis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * SpringBoot自带StringRedisTemplate来操控redis
 * 模拟了两个常用方法，get数据，put数据
 * 
 * @author wenbochang
 * @date 2018年5月27日
 */
@RestController
public class StringSimpleRedis {

	@Autowired
	StringRedisTemplate stringRedisTemplate;
	
	
	@RequestMapping(value = "/get/string/redis", method = RequestMethod.GET)
	public String getRedisData() {
		
		StringBuilder sb = new StringBuilder();
		sb.append(stringRedisTemplate.toString());
		sb.append("   \n\n");
		sb.append(stringRedisTemplate.opsForValue().get("k1"));
		
		return sb.toString();
	}
	
	//获取post传过来的参数
	@RequestMapping(value = "/put/string/redis", method = RequestMethod.POST)
	public String putRedisData(@Param("key") String key,
			@Param("value") String value) {
		
		stringRedisTemplate.opsForValue().set(key, value);
		return key + ": " + value;
	}
}










