package com.epam.training.sportsbetting.web.forms;

public class OutcomeForm {
    private String description;
    private OddForm odd;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public OddForm getOdd() {
        return odd;
    }

    public void setOdd(OddForm odd) {
        this.odd = odd;
    }
}
