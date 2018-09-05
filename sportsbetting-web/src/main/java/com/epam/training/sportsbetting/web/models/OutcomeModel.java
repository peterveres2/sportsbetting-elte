package com.epam.training.sportsbetting.web.models;

public class OutcomeModel {
    private final int id;
    private final String value;
    private final float odd;

    public OutcomeModel(int id, String value, float odd) {
        this.id = id;
        this.value = value;
        this.odd = odd;
    }

    public int getId() {
        return id;
    }

    public String getValue() {
        return value;
    }

    public float getOdd() {
        return odd;
    }
}
