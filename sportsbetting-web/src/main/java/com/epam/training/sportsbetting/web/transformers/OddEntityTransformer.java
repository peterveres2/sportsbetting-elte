package com.epam.training.sportsbetting.web.transformers;

import com.epam.training.sportsbetting.domain.OutcomeOdd;
import com.epam.training.sportsbetting.web.forms.OddForm;

public class OddEntityTransformer extends AbstractTransformer<OddForm, OutcomeOdd> {

    @Override
    public OutcomeOdd transform(OddForm oddForm) {
        OutcomeOdd odd = new OutcomeOdd();
        odd.setOddValue(oddForm.getOddValue());
        odd.setValidFrom(oddForm.getValidFrom());
        odd.setValidTo(oddForm.getValidTo());
        return odd;
    }

}
