package com.epam.training.sportsbetting.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.epam.training.sportsbetting.domain.DelayAmount;


public class DelayControlService {
	
	@Autowired
	private DelayAmount delayAmount;
	
	public void changeDelayAmount(Integer newDelayAmount){
		delayAmount.setDelay(newDelayAmount);
	}

}
