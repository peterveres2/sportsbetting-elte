package com.epam.training.sportsbetting.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

@Entity
public class Bet {
    @Id
    @GeneratedValue
    private int id;
    @ManyToOne(cascade = CascadeType.PERSIST)
    private final SportEvent event;
    @OneToMany(cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
    @Fetch(value = FetchMode.SUBSELECT)
    private final List<Outcome> outcomes;
    private final String description;
    @Enumerated(EnumType.STRING)
    private final BetType type;

    public Bet(SportEvent event, List<Outcome> outcomes, String description, BetType type) {
        this.event = event;
        this.outcomes = new ArrayList<Outcome>(outcomes);
        this.description = description;
        this.type = type;
    }

    public Bet() {
        event = null;
        outcomes = null;
        description = null;
        this.type = null;
    }

    public List<Outcome> getOutcomes() {
        return outcomes;
    }

    public String getDescription() {
        return description;
    }

    public BetType getType() {
        return type;
    }

    public List<Outcome> getResultOutcomes() {
        return event.getResultOutcomes();
    }

    public List<String> getResultOutcomeValues() {
        return event.getResultOutcomeValues();
    }

    public String getEventTitle() {
        return event.getTitle();
    }

    public SportEvent getEvent() {
        return event;
    }

    @Override
    public String toString() {
        return "Bet [id=" + id + ", event=" + event + ", outcomes=" + outcomes + ", description=" + description + ", type=" + type + "]";
    }

    public int getId() {
        return id;
    }
}
