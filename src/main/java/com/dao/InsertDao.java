package com.dao;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface InsertDao {

	
	@Insert(value = "insert into user(userName, passWord) values(#{username}, #{password})")
	public void insetUser(@Param("username") String username,
			@Param("password") String password);
}
