package com.epam.training.sportsbetting.web.models;

public class BetModel {
    private final int id;
    private final String description;
    private final String type;

    public BetModel(int id, String description, String type) {
        this.id = id;
        this.description = description;
        this.type = type;
    }

    public int getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public String getType() {
        return type;
    }
}
