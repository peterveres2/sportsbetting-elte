package com.epam.training.sportsbetting.domain;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.OneToOne;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public abstract class SportEvent {
    @Id
    @GeneratedValue
    private int id;
    private final String title;
    private final LocalDateTime start;
    private final LocalDateTime end;
    @OneToOne(cascade = CascadeType.PERSIST)
    private Result result;

    public SportEvent(String title, LocalDateTime start, LocalDateTime end) {
        this.title = title;
        this.start = start;
        this.end = end;
    }

    public String getTitle() {
        return title;
    }

    public void setResult(Result result) {
        this.result = result;
    }

    public List<Outcome> getResultOutcomes() {
        return result.getOutcomes();
    }

    public List<String> getResultOutcomeValues() {
        return result.getOutcomeValues();
    }

    public LocalDateTime getStart() {
        return start;
    }

    public LocalDateTime getEnd() {
        return end;
    }

    public int getId() {
        return id;
    }
}
