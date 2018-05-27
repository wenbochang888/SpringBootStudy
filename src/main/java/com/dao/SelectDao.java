package com.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface SelectDao {

	@Select(value = "select * from user")
	public List<User> findAllInfo();
	
	@Select(value = "select userId id, userName, passWord from user where userId = #{id}")
	public User findById(@Param("id") String id);
}





