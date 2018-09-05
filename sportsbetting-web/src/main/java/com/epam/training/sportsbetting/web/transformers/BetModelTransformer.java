package com.epam.training.sportsbetting.web.transformers;

import com.epam.training.sportsbetting.domain.Bet;
import com.epam.training.sportsbetting.web.models.BetModel;

public class BetModelTransformer extends AbstractTransformer<Bet, BetModel> {

    @Override
    public BetModel transform(Bet bet) {
        return new BetModel(bet.getId(), bet.getDescription(), bet.getType().toString());
    }

}
