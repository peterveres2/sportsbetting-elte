package com.epam.training.sportsbetting.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;


@Entity
public class Outcome {
    @Id
    @GeneratedValue
    private int id;
    private String value;
    @OneToMany(fetch= FetchType.EAGER,mappedBy="outcome", cascade=CascadeType.ALL)
    private List<OutcomeOdd> odds;
    private boolean won;

    public Outcome(String value, List<OutcomeOdd> odds) {
        this.value = value;
        this.odds = odds;
    }

    public Outcome() {

    }

    public Outcome(String value) {
        this.value = value;
        this.odds = new ArrayList<>();
    }

    public String getValue() {
        return value;
    }

    public float getLatestOddValue() {
        return odds.get(odds.size()-1).getOddValue();
    }

    public void addOdd(OutcomeOdd odd) {
        this.odds.add(odd);
    }

    public String getLatestOddStart() {
        return odds.get(odds.size()-1).getValidFrom().toString();
    }

    public String getLatestOddEnd() {
        return odds.get(odds.size()-1).getValidTo().toString();
    }

    public OutcomeOdd getLatestOdd() {
        return odds.get(odds.size()-1);
    }

    public void setWonTrue() {
        won = true;
    }

    public boolean checkIfWon() {
        return won;
    }

    @Override
    public String toString() {
        return "Outcome [id=" + id + ", value=" + value + ", odd=" + odds + ", won=" + won + "]";
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + id;
        result = prime * result + ((value == null) ? 0 : value.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        Outcome other = (Outcome) obj;
        if (id != other.id) {
            return false;
        }
        if (value == null) {
            if (other.value != null) {
                return false;
            }
        } else if (!value.equals(other.value)) {
            return false;
        }
        return true;
    }

    public int getId() {
        return id;
    }
}
