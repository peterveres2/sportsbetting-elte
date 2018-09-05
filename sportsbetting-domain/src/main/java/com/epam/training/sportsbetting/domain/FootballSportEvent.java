package com.epam.training.sportsbetting.domain;

import java.time.LocalDateTime;
import javax.persistence.Entity;

@Entity
public class FootballSportEvent extends SportEvent {

    public FootballSportEvent(String title, LocalDateTime start, LocalDateTime end) {
        super(title, start, end);
    }

    public FootballSportEvent() {
        super(null, null, null);
    }
}
