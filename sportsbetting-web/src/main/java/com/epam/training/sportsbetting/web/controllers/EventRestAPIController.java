package com.epam.training.sportsbetting.web.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.epam.training.sportsbetting.domain.Wager;
import com.epam.training.sportsbetting.service.EventService;
import com.epam.training.sportsbetting.web.forms.WagerForm;
import com.epam.training.sportsbetting.web.models.BetModel;
import com.epam.training.sportsbetting.web.models.OutcomeModel;
import com.epam.training.sportsbetting.web.models.SportEventModel;
import com.epam.training.sportsbetting.web.models.WagerModel;
import com.epam.training.sportsbetting.web.transformers.BetModelTransformer;
import com.epam.training.sportsbetting.web.transformers.OutcomeModelTransformer;
import com.epam.training.sportsbetting.web.transformers.SportEventModelTransformer;
import com.epam.training.sportsbetting.web.transformers.WagerEntityTransformer;
import com.epam.training.sportsbetting.web.transformers.WagerModelTransformer;

@RestController
public class EventRestAPIController {
    @Autowired
    private EventService service;
    @Autowired
    private WagerModelTransformer wagerModelTransformer;
    @Autowired
    private SportEventModelTransformer sportEventModelTransformer;
    @Autowired
    private BetModelTransformer betModelTransformer;
    @Autowired
    private OutcomeModelTransformer outcomeModelTransformer;
    @Autowired
    private WagerEntityTransformer wagerEntityTransformer;


    @RequestMapping(value = "/loadEvents", method = RequestMethod.GET)
    public List<SportEventModel> loadEvents() {
        return sportEventModelTransformer.transform(service.loadEvents());
    }

    @RequestMapping(value = "/loadWagers", method = RequestMethod.POST)
    public List<WagerModel> loadWagers(@ModelAttribute("playerId") int playerId) {
        return wagerModelTransformer.transform(service.loadWagers(playerId));
    }

    @RequestMapping(value = "/wagerControl", method = RequestMethod.POST)
    public void deleteWager(@ModelAttribute("wagerId") int wagerId) {
        service.deleteWager(wagerId);
    }

    @RequestMapping(value = "/loadBets", method = RequestMethod.POST)
    public List<BetModel> loadBets(@ModelAttribute("eventId") int eventId) {
        return betModelTransformer.transform(service.loadBets(eventId));
    }

    @RequestMapping(value = "/loadOutcomes", method = RequestMethod.POST)
    public List<OutcomeModel> loadOutcomes(@ModelAttribute("betId") int betId) {
        return outcomeModelTransformer.transform(service.loadOutcomes(betId));
    }

    @RequestMapping(value = "/addWager", method = RequestMethod.POST)
    public void addWager(@RequestBody WagerForm wagerForm) {
        Wager wager = wagerEntityTransformer.transform(wagerForm);
        service.addWager(wager);
    }

    
 
    
}
