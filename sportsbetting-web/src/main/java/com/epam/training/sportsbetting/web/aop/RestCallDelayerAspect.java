package com.epam.training.sportsbetting.web.aop;

import javax.annotation.Resource;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.jmx.export.annotation.ManagedOperation;
import org.springframework.jmx.export.annotation.ManagedResource;
import org.springframework.stereotype.Component;

import com.epam.training.sportsbetting.domain.DelayAmount;

@Component
@Aspect
@ManagedResource
public class RestCallDelayerAspect {

	
	@Resource
	private DelayAmount delayAmount;
	
	@ManagedOperation
	@Before("within(com.epam.training.sportsbetting.web.controllers..*)")
	public void applyDelay(JoinPoint joinPoint) throws Throwable{
	   Thread.sleep(delayAmount.getDelay());
	}
}