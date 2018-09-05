package com.epam.training.sportsbetting.web.transformers;

import com.epam.training.sportsbetting.domain.Player;
import com.epam.training.sportsbetting.web.forms.RegistrationForm;

public class PlayerEntityTransformer extends AbstractTransformer<RegistrationForm, Player> {
    @Override
    public Player transform(RegistrationForm registrationForm) {
        Player player = new Player();
        player.setUserName(registrationForm.getUserName());
        player.setName(registrationForm.getName());
        player.setDateOfBirth(registrationForm.getDateOfBirth());
        player.setBalance(registrationForm.getBalance());
        player.setAccountNumber(registrationForm.getAccountNumber());
        player.setCurrency(registrationForm.getCurrency());
        return player;
    }
}
