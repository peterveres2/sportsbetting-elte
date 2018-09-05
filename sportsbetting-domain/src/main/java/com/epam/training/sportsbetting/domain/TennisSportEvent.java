package com.epam.training.sportsbetting.domain;

import java.time.LocalDateTime;

public class TennisSportEvent extends SportEvent {

    public TennisSportEvent(String title, LocalDateTime start, LocalDateTime end) {
        super(title, start, end);
    }

    public TennisSportEvent() {
        super(null, null, null);
    }
}
