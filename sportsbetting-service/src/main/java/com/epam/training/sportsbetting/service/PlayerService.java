package com.epam.training.sportsbetting.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.epam.training.sportsbetting.domain.Player;
import com.epam.training.sportsbetting.domain.User;
import com.epam.training.sportsbetting.repositories.PlayerRepository;
import com.epam.training.sportsbetting.repositories.UserRepository;


public class PlayerService {
	
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private PlayerRepository playerRepository;

	 public Player registerPlayer(Player player) {
	        return playerRepository.save(player);
	}

	 public void registerUser(User user, Player player) {
	        user.setPlayer(player);
	        userRepository.save(user);
	}
	public Player loadPlayer(int playerId) {
	        return playerRepository.findOne(playerId);
	}

    public Player loadPlayer(String username) {
        return userRepository.findByUsername(username).getPlayer();
    }

    public User findUser(String username) {
        return userRepository.findByUsername(username);
    }

    
}
