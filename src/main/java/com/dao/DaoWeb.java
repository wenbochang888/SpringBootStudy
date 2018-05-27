package com.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * SpringBoot整合Mybatis
 *
 * @author wenbochang
 * @date 2018年5月27日
 */
@RestController
public class DaoWeb {
	
	@Autowired
	SelectDao selectDao;
	@Autowired
	InsertDao insertDao;
	
	@RequestMapping(value = "/get/user", method = RequestMethod.GET)
	public String selectAlloInfo() {
		
		List<User> list = selectDao.findAllInfo();
		
		return list.toString();
	}
	
	@RequestMapping(value = "/get/user/{id}", method = RequestMethod.GET)
	public String selectAlloInfo(@PathVariable("id") String id) {
		
		System.out.println("id = " + id);
		User user = selectDao.findById(id);
		System.out.println("user = " + user);
		
		return user.toString();
	}
	
	@RequestMapping(value = "/put/user", method = RequestMethod.POST)
	public void insertUser(@Param("username") String username,
			@Param("password") String password) {
		
		insertDao.insetUser(username, password);
	}
}













