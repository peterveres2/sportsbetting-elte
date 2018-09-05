package com.epam.training.sportsbetting.domain;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
public class Wager {
    @Id
    @GeneratedValue
    private int id;
    @OneToOne
    private Player player;
    @ManyToOne
    private Bet bet;
    @OneToOne
    private OutcomeOdd outcomeOdd;
    private int amount;
    @Enumerated(EnumType.STRING)
    private Currency currency;
    private LocalDate timestamp;
    private boolean processed;
    private boolean winner;

    public Wager(Player player, Bet bet, OutcomeOdd outcomeOdd, int amount, Currency currency) {
        this.player = player;
        this.bet = bet;
        this.outcomeOdd = outcomeOdd;
        this.amount = amount;
        this.currency = currency;
        this.timestamp = LocalDate.now();
        this.processed = false;
    }

    public Wager() {
    }

    public int getAmount() {
        return amount;
    }

    public boolean isWinner() {
        return winner;
    }

    public float getOddValue() {
        return outcomeOdd.getOddValue();
    }

    public boolean isProcessed() {
        return processed;
    }

    public LocalDate getTimestamp() {
        return timestamp;
    }

    public Currency getCurrency() {
        return currency;
    }

    public Player getPlayer() {
        return player;
    }

    public OutcomeOdd getOutcomeOdd() {
        return outcomeOdd;
    }

    public Bet getBet() {
        return bet;
    }

    public void setBet(Bet bet) {
        this.bet = bet;
    }

    public String getBetDescription() {
        return bet.getDescription();
    }

    public String getBetType() {
        return bet.getType().toString();
    }

    public String getEventTitle() {
        return bet.getEventTitle();
    }

    public String getEventType() {
        return bet.getEvent().getClass().getSimpleName();
    }

    public int getId() {
        return id;
    }

    public void setProcessed() {
        processed = true;
    }

    public void setWinner(boolean winner) {
        this.winner = winner;
    }
}
