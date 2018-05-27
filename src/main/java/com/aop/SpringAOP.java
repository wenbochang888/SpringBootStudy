package com.aop;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class SpringAOP {

	@Pointcut(value = "execution (public * com.aop.Main.*(..))")
	public void log() {
	}
	
	@Before(value = "log()")
	public void doBefore() {
		
		System.out.println("AOP 前置拦截");
	}
	
	@After(value = "log()")
	public void doAfter() {
		
		System.out.println("AOP 后置拦截");
	}
}






