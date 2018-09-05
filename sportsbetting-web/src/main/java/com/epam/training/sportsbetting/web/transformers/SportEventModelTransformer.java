package com.epam.training.sportsbetting.web.transformers;

import com.epam.training.sportsbetting.domain.SportEvent;
import com.epam.training.sportsbetting.web.models.SportEventModel;

public class SportEventModelTransformer extends AbstractTransformer<SportEvent, SportEventModel> {
    public SportEventModel transform(SportEvent sportEvent) {
        String eventType = sportEvent.getClass().getSimpleName().replace("SportEvent", " Match");
        return new SportEventModel(sportEvent.getId(), sportEvent.getTitle(), eventType, sportEvent.getStart(), sportEvent.getEnd());
    }
}
