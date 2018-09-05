package com.epam.training.sportsbetting.web.transformers;

import com.epam.training.sportsbetting.domain.Player;
import com.epam.training.sportsbetting.domain.User;
import com.epam.training.sportsbetting.web.forms.RegistrationForm;

public class UserAndPlayerEntityTransformer {
    private User user;
    private Player player;

    public void transform(RegistrationForm registrationForm) {
        player = new Player();
        player.setUserName(registrationForm.getUserName());
        player.setName(registrationForm.getName());
        player.setDateOfBirth(registrationForm.getDateOfBirth());
        player.setBalance(registrationForm.getBalance());
        player.setAccountNumber(registrationForm.getAccountNumber());
        player.setCurrency(registrationForm.getCurrency());
        user = new User();
        user.setUsername(registrationForm.getName());
        user.setPassword(registrationForm.getPassword());
        user.setPlayer(player);
    }

    public User getUser() {
        return user;
    }

    public Player getPlayer() {
        return player;
    }
}
