package com.epam.training.sportsbetting.web.transformers;

import com.epam.training.sportsbetting.domain.Outcome;
import com.epam.training.sportsbetting.web.models.OutcomeModel;

public class OutcomeModelTransformer extends AbstractTransformer<Outcome, OutcomeModel> {

    @Override
    public OutcomeModel transform(Outcome outcome) {
        return new OutcomeModel(outcome.getId(), outcome.getValue(), outcome.getLatestOddValue());
    }

}
