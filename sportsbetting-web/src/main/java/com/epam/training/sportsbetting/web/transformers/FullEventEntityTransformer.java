package com.epam.training.sportsbetting.web.transformers;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.epam.training.sportsbetting.domain.Bet;
import com.epam.training.sportsbetting.domain.BetType;
import com.epam.training.sportsbetting.domain.FootballSportEvent;
import com.epam.training.sportsbetting.domain.Outcome;
import com.epam.training.sportsbetting.domain.OutcomeOdd;
import com.epam.training.sportsbetting.domain.SportEvent;
import com.epam.training.sportsbetting.domain.TennisSportEvent;
import com.epam.training.sportsbetting.web.forms.BetForm;
import com.epam.training.sportsbetting.web.forms.FullEventForm;
import com.epam.training.sportsbetting.web.forms.OutcomeForm;

public class FullEventEntityTransformer extends AbstractTransformer<FullEventForm, List<Bet>> {

    @Autowired
    private OddEntityTransformer oddEntityTransformer;

    @Override
    public List<Bet> transform(FullEventForm eventForm) {
        String eventTitle = eventForm.getEventTitle();
        LocalDateTime eventStart = eventForm.getStart();
        LocalDateTime eventEnd = eventForm.getEnd();
        SportEvent event = null;
        if (eventForm.getEventType().equals("FOOTBALL")) {
            event = new FootballSportEvent(eventTitle, eventStart, eventEnd);
        } else if (eventForm.getEventType().equals("TENNIS")) {
            event = new TennisSportEvent(eventTitle, eventStart, eventEnd);
        }
        List<Bet> bets = new ArrayList<>(eventForm.getBets().size());
        for (BetForm betForm : eventForm.getBets()) {
            List<Outcome> outcomes = new ArrayList<>();
            for (OutcomeForm outcomeForm : betForm.getOutcomes()) {
                OutcomeOdd odd = oddEntityTransformer.transform(outcomeForm.getOdd());
                ArrayList<OutcomeOdd> odds = new ArrayList<OutcomeOdd>();
                odds.add(odd);
                String value = outcomeForm.getDescription();
                Outcome outcome = new Outcome(value, odds);
                odd.setOutcome(outcome);
                outcomes.add(outcome);
            }
            String description = betForm.getDescription();
            BetType type = BetType.valueOf(betForm.getType());
            bets.add(new Bet(event, outcomes, description, type));
        }
        return bets;
    }
}
