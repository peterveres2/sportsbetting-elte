package com.epam.training.sportsbetting.web.transformers;

import org.springframework.beans.factory.annotation.Autowired;

import com.epam.training.sportsbetting.domain.SportEvent;
import com.epam.training.sportsbetting.domain.Wager;
import com.epam.training.sportsbetting.web.models.SportEventModel;
import com.epam.training.sportsbetting.web.models.WagerModel;

public class ModelTransformer {
    @Autowired
    private SportEventModelTransformer sportEventModelTransformer;
    @Autowired
    private WagerModelTransformer wagerModelTransformer;

    public SportEventModel transform(SportEvent sportEvent) {
        return sportEventModelTransformer.transform(sportEvent);
    }

    public WagerModel transform(Wager wager) {
        return wagerModelTransformer.transform(wager);
    }
}
