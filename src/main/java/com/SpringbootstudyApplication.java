package com;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringbootstudyApplication {

	public static void main(String[] args) {

		String x = "x";
		System.out.println("测试新开分支，并且合并到主master");
		System.out.println("这里应该会出现冲突代码" + x);
		SpringApplication.run(SpringbootstudyApplication.class, args);
	}
}







