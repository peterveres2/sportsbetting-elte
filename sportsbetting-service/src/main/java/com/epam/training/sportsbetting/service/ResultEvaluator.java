package com.epam.training.sportsbetting.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.epam.training.sportsbetting.domain.Outcome;
import com.epam.training.sportsbetting.domain.Player;
import com.epam.training.sportsbetting.domain.Wager;
import com.epam.training.sportsbetting.repositories.PlayerRepository;
import com.epam.training.sportsbetting.repositories.WagerRepository;

public class ResultEvaluator {
    @Autowired
    private WagerRepository wagerRepository;
    @Autowired
    private PlayerRepository playerRepository;

    public void evaluate(List<Outcome> outcomes) {
        for (Wager wager : wagerRepository.findAll()) {
            Outcome outcome = wager.getOutcomeOdd().getOutcome();
            if (outcomes.contains(outcome)) {
                wager.setWinner(true);
                wager.setProcessed();
                int prize = (int) (wager.getAmount() * wager.getOddValue());
                Player player = wager.getPlayer();
                player.setBalance(player.getBalance() + prize);
                playerRepository.save(player);
                wagerRepository.save(wager);
            } else if (wager.getBet().getOutcomes().contains(outcome)) {
                wager.setWinner(false);
                wager.setProcessed();
                wagerRepository.save(wager);
            }
        }

    }

}
