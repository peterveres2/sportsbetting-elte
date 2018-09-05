package com.epam.training.sportsbetting.web.forms;

import java.util.List;

public class BetForm {
    private List<OutcomeForm> outcomes;
    private String description;
    private String type;

    public List<OutcomeForm> getOutcomes() {
        return outcomes;
    }

    public void setOutcomes(List<OutcomeForm> outcomes) {
        this.outcomes = outcomes;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
