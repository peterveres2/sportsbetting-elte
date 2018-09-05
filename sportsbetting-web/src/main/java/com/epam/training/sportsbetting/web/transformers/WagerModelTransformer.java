package com.epam.training.sportsbetting.web.transformers;

import com.epam.training.sportsbetting.domain.Wager;
import com.epam.training.sportsbetting.web.models.WagerModel;

public class WagerModelTransformer extends AbstractTransformer<Wager, WagerModel> {
    public WagerModel transform(Wager wager) {
        WagerModel wm = new WagerModel();
        wm.setId(wager.getId());
        wm.setEventTitle(wager.getEventTitle());
        wm.setEventType(wager.getEventType());
        wm.setBetType(prettify(wager.getBetType()));
        wm.setBetDescription(wager.getBetDescription());
        wm.setOutcomeValue(wager.getOutcomeOdd().getOutcomeValue());
        wm.setOddValue(wager.getOddValue());
        wm.setAmount(wager.getAmount());
        wm.setCurrency(wager.getCurrency().toString());
        wm.setWinner(wager.isWinner());
        wm.setProcessed(wager.isProcessed());
        return wm;
    }

    private String prettify(String description) {
        String prettyDescription = description.replace('_', ' ');
        prettyDescription = prettyDescription.substring(0, 1).toUpperCase() + prettyDescription.substring(1).toLowerCase();
        return prettyDescription;
    }
}
