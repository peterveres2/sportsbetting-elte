package com.epam.training.sportsbetting.domain;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class OutcomeOdd {
    @Id
    @GeneratedValue
    private int id;
    private float oddValue;
    private LocalDate validFrom;
    private LocalDate validTo;
    @ManyToOne
    private Outcome outcome;

    public OutcomeOdd(float oddValue, LocalDate validFrom, LocalDate validTo, Outcome outcome) {
        this.oddValue = oddValue;
        this.validFrom = validFrom;
        this.validTo = validTo;
        this.outcome = outcome;
    }

    public OutcomeOdd() {
    }

    public int wonAmount(int wagedAmount) {
        return (int) (wagedAmount * oddValue);
    }

    public float getOddValue() {
        return oddValue;
    }

    public LocalDate getValidFrom() {
        return validFrom;
    }

    public LocalDate getValidTo() {
        return validTo;
    }

    public boolean checkIfWon() {
        return outcome.checkIfWon();
    }

    public String getOutcomeValue() {
        return outcome.getValue();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Outcome getOutcome() {
        return outcome;
    }

    public void setOutcome(Outcome outcome) {
        this.outcome = outcome;
    }

    public void setOddValue(float oddValue) {
        this.oddValue = oddValue;
    }

    public void setValidFrom(LocalDate validFrom) {
        this.validFrom = validFrom;
    }

    public void setValidTo(LocalDate validTo) {
        this.validTo = validTo;
    }
}
