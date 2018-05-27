package com.web;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SimpleUrlMapper {

	
	//Hello World
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String index() {
		return "Hello World";
	}
	
	//带参数映射
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public String id(@PathVariable(value = "id") String id) {
		
		return "id = " + id;
	}
}














