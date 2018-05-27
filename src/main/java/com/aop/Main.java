package com.aop;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Main {
	
	
	@RequestMapping("/aop")
	public void test() {
		
		System.out.println("我是AOP测试");
	}
}









