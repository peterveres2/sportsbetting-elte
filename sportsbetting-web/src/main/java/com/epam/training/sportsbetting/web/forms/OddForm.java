package com.epam.training.sportsbetting.web.forms;

import java.time.LocalDate;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateSerializer;

public class OddForm {
    private float oddValue;
    @JsonSerialize(using = LocalDateSerializer.class)
    private LocalDate validFrom;
    @JsonSerialize(using = LocalDateSerializer.class)
    private LocalDate validTo;

    public float getOddValue() {
        return oddValue;
    }

    public void setOddValue(float oddValue) {
        this.oddValue = oddValue;
    }

    public LocalDate getValidFrom() {
        return validFrom;
    }

    public void setValidFrom(LocalDate validFrom) {
        this.validFrom = validFrom;
    }

    public LocalDate getValidTo() {
        return validTo;
    }

    public void setValidTo(LocalDate validTo) {
        this.validTo = validTo;
    }

    @Override
    public String toString() {
        return "OddForm [oddValue=" + oddValue + ", validFrom=" + validFrom + ", validTo=" + validTo + "]";
    }
}
