package com.epam.training.sportsbetting.web.models;

public class WagerModel {
    private int id;
    private String eventTitle;
    private String eventType;
    private String betType;
    private String betDescription;
    private String outcomeValue;
    private float oddValue;
    private int amount;
    private String currency;
    private boolean winner;
    private boolean processed;

    public int getId() {
        return id;
    }

    public String getEventTitle() {
        return eventTitle;
    }

    public String getEventType() {
        return eventType;
    }

    public String getBetType() {
        return betType;
    }

    public String getBetDescription() {
        return betDescription;
    }

    public String getOutcomeValue() {
        return outcomeValue;
    }

    public float getOddValue() {
        return oddValue;
    }

    public int getAmount() {
        return amount;
    }

    public String getCurrency() {
        return currency;
    }

    public boolean isWinner() {
        return winner;
    }

    public boolean isProcessed() {
        return processed;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setEventTitle(String eventTitle) {
        this.eventTitle = eventTitle;
    }

    public void setEventType(String eventType) {
        this.eventType = eventType;
    }

    public void setBetType(String betType) {
        this.betType = betType;
    }

    public void setBetDescription(String betDescription) {
        this.betDescription = betDescription;
    }

    public void setOutcomeValue(String outcomeValue) {
        this.outcomeValue = outcomeValue;
    }

    public void setOddValue(float oddValue) {
        this.oddValue = oddValue;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public void setWinner(boolean winner) {
        this.winner = winner;
    }

    public void setProcessed(boolean processed) {
        this.processed = processed;
    }
}
