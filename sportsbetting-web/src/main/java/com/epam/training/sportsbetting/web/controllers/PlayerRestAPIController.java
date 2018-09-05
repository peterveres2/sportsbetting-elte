package com.epam.training.sportsbetting.web.controllers;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.epam.training.sportsbetting.domain.Player;
import com.epam.training.sportsbetting.service.PlayerService;
import com.epam.training.sportsbetting.service.TestDataMaker;
import com.epam.training.sportsbetting.web.forms.RegistrationForm;
import com.epam.training.sportsbetting.web.transformers.PlayerEntityTransformer;
import com.epam.training.sportsbetting.web.transformers.UserEntityTransformer;


@RestController
public class PlayerRestAPIController {
	
	@Autowired
    private PlayerService playerService;
    @Autowired
    private TestDataMaker dataGenerator;
	@Autowired
	private PlayerEntityTransformer playerEntityTransformer;
	@Autowired
	private UserEntityTransformer userEntityTransformer;
	
	@RequestMapping(value = "/registration", method = RequestMethod.POST)
    public ResponseEntity<Object> registerPlayer(@RequestBody RegistrationForm registrationForm) {
		if(playerService.findUser(registrationForm.getUserName())==null){
		    Player player = playerService.registerPlayer(playerEntityTransformer.transform(registrationForm));
		    playerService.registerUser(userEntityTransformer.transform(registrationForm), player);
		    return new ResponseEntity<Object>(player,HttpStatus.OK);
		} else {
			return new ResponseEntity<Object>(HttpStatus.I_AM_A_TEAPOT);
		}
    }

    @RequestMapping(value = "/updatePlayer", method = RequestMethod.POST)
    public Object updatePlayer(@RequestBody Player player) {
        try {
            return playerService.registerPlayer(player);
        } catch (Exception e) {
            return "{\"alert\" : \"Request and database not in sync. Please try again.\"}";
        }
    }
    
    @RequestMapping(value = "/login/{success}")
    public boolean login(@PathVariable String success) {
        return Boolean.parseBoolean(success);
    }

    @RequestMapping(value = "/testPrincipal")
    public Principal testPrincipal(Principal principal) {
        return principal;
    }

    @RequestMapping(value = "/loadPlayer")
    public Player loadPlayer(Principal principal) {
        return playerService.loadPlayer(principal.getName());
    }

    @RequestMapping(value = "/generateData")
    public void generateData() {
        dataGenerator.generateData();
    }
}
