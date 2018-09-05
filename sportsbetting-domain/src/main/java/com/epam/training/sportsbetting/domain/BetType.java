package com.epam.training.sportsbetting.domain;

public enum BetType {
    ALL_GOALS_BET("All goals bet"), WIN_BET("Win bet"), PLAYER_GOALS_BET("Player goals bet");

    private String value;

    BetType(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return value;
    }
};
