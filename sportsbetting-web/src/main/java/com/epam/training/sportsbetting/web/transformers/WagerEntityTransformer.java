package com.epam.training.sportsbetting.web.transformers;

import org.springframework.beans.factory.annotation.Autowired;

import com.epam.training.sportsbetting.domain.Bet;
import com.epam.training.sportsbetting.domain.OutcomeOdd;
import com.epam.training.sportsbetting.domain.Wager;
import com.epam.training.sportsbetting.service.EventService;
import com.epam.training.sportsbetting.web.forms.WagerForm;

public class WagerEntityTransformer extends AbstractTransformer<WagerForm, Wager> {
    @Autowired
    private EventService service;

    @Override
    public Wager transform(WagerForm wagerForm) {
        Bet bet = service.loadBet(wagerForm.getBetId());
        OutcomeOdd outcomeOdd = service.loadOddByOutcome(wagerForm.getOutcomeId());
        return new Wager(wagerForm.getPlayer(), bet, outcomeOdd, wagerForm.getAmount(), wagerForm.getCurrency());
    }
}
