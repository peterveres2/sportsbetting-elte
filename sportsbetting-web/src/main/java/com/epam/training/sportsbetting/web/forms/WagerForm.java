package com.epam.training.sportsbetting.web.forms;

import java.time.LocalDate;

import com.epam.training.sportsbetting.domain.Currency;
import com.epam.training.sportsbetting.domain.Player;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateSerializer;;

public class WagerForm {
    private Player player;
    private int betId;
    private int outcomeId;
    private int amount;
    private Currency currency;
    @JsonSerialize(using = LocalDateSerializer.class)
    private LocalDate timestamp;

    public int getBetId() {
        return betId;
    }

    public Currency getCurrency() {
        return currency;
    }

    public void setBetId(int betId) {
        this.betId = betId;
    }

    public void setCurrency(Currency currency) {
        this.currency = currency;
    }

    public Player getPlayer() {
        return player;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public LocalDate getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDate timestamp) {
        this.timestamp = timestamp;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    @Override
    public String toString() {
        return "WagerForm [player=" + player + ", betId=" + betId + ", outcomeId=" + outcomeId + ", amount=" + amount + ", currency=" + currency
                + ", timestamp=" + timestamp + "]";
    }

    public int getOutcomeId() {
        return outcomeId;
    }

    public void setOutcomeId(int outcomeId) {
        this.outcomeId = outcomeId;
    }
}
