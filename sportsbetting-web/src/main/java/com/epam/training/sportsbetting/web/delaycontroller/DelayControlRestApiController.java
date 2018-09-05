package com.epam.training.sportsbetting.web.delaycontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.epam.training.sportsbetting.service.DelayControlService;

@RestController
public class DelayControlRestApiController {
	
	@Autowired
	DelayControlService delayControlService;
	
    @RequestMapping(value = "/changeDelay", method = RequestMethod.POST)
    public void changeDelay(@ModelAttribute("delayAmount") Integer delayAmount) {
        delayControlService.changeDelayAmount(delayAmount);
    }

}
