package com.epam.training.sportsbetting.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Result {
    @Id
    @GeneratedValue
    private int id;
    @OneToMany(fetch = FetchType.EAGER)
    private List<Outcome> outcomes;

    public Result(List<Outcome> outcomes) {
        this.outcomes = outcomes;
    }

    public Result() {
    }

    public List<String> getOutcomeValues() {
        List<String> outcomeValues = new ArrayList<>(outcomes.size());
        for (Outcome outcome : outcomes) {
            outcomeValues.add(outcome.getValue());
        }
        return outcomeValues;
    }

    public List<Outcome> getOutcomes() {
        return outcomes;
    }

    @Override
    public String toString() {
        return "Result [outcomes=" + outcomes + "]";
    }
}
