package com.epam.training.sportsbetting.web.models;

import java.time.LocalDateTime;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;

public class SportEventModel {
    private final int id;
    private final String title;
    private final String type;
    @JsonDeserialize(using = LocalDateTimeDeserializer.class)
    private final LocalDateTime start;
    @JsonDeserialize(using = LocalDateTimeDeserializer.class)
    private final LocalDateTime end;

    public SportEventModel(int id, String title, String type, LocalDateTime start, LocalDateTime end) {
        this.id = id;
        this.title = title;
        this.type = type;
        this.start = start;
        this.end = end;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public LocalDateTime getStart() {
        return start;
    }

    public LocalDateTime getEnd() {
        return end;
    }

    public String getType() {
        return type;
    }
}
