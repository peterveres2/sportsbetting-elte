package com.epam.training.sportsbetting.web.transformers;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;

import com.epam.training.sportsbetting.domain.Outcome;
import com.epam.training.sportsbetting.domain.OutcomeOdd;
import com.epam.training.sportsbetting.web.forms.OutcomeForm;

public class OutcomeEntityTranformer extends AbstractTransformer<OutcomeForm, Outcome> {
    @Autowired
    private OddEntityTransformer oddEntityTransformer;

    @Override
    public Outcome transform(OutcomeForm outcomeForm) {
        String value = outcomeForm.getDescription();
        OutcomeOdd odd = oddEntityTransformer.transform(outcomeForm.getOdd());
        ArrayList<OutcomeOdd> odds = new ArrayList<>();
        odds.add(odd);
        Outcome outcome = new Outcome(value, odds);
        odd.setOutcome(outcome);
        return outcome;
    }

}
