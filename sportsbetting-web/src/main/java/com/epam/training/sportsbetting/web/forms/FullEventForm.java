package com.epam.training.sportsbetting.web.forms;

import java.time.LocalDateTime;
import java.util.List;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;

public class FullEventForm {
    private enum EventType {
        FOOTBALL, TENNIS
    };

    private String eventTitle;
    private EventType eventType;
    @JsonSerialize(using = LocalDateTimeSerializer.class)
    private LocalDateTime start;
    @JsonSerialize(using = LocalDateTimeSerializer.class)
    private LocalDateTime end;
    private List<BetForm> bets;

    public String getEventTitle() {
        return eventTitle;
    }

    public void setEventTitle(String eventTitle) {
        this.eventTitle = eventTitle;
    }

    public LocalDateTime getStart() {
        return start;
    }

    public void setStart(LocalDateTime start) {
        this.start = start;
    }

    public LocalDateTime getEnd() {
        return end;
    }

    public void setEnd(LocalDateTime end) {
        this.end = end;
    }

    public List<BetForm> getBets() {
        return bets;
    }

    public void setBets(List<BetForm> bets) {
        this.bets = bets;
    }

    public String getEventType() {
        return eventType.toString();
    }

    public void setEventType(EventType eventType) {
        this.eventType = eventType;
    }

}
