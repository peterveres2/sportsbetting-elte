package com.epam.training.sportsbetting.web.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.epam.training.sportsbetting.domain.Outcome;
import com.epam.training.sportsbetting.domain.Player;
import com.epam.training.sportsbetting.domain.SportEvent;
import com.epam.training.sportsbetting.domain.Wager;
import com.epam.training.sportsbetting.service.EventService;
import com.epam.training.sportsbetting.service.PlayerService;
import com.epam.training.sportsbetting.web.forms.FullEventForm;
import com.epam.training.sportsbetting.web.forms.OddForm;
import com.epam.training.sportsbetting.web.models.OutcomeModel;
import com.epam.training.sportsbetting.web.models.PlayerInfoModel;
import com.epam.training.sportsbetting.web.transformers.FullEventEntityTransformer;
import com.epam.training.sportsbetting.web.transformers.OddEntityTransformer;
import com.epam.training.sportsbetting.web.transformers.OutcomeModelTransformer;
import com.epam.training.sportsbetting.web.transformers.PlayerInfoModelTransformer;

@RestController
public class SportBettingRestController {
	@Autowired
    private PlayerService playerService;
    @Autowired
    private EventService eventService;
    @Autowired
    private OddEntityTransformer oddEntityTransformer;
    @Autowired
    private FullEventEntityTransformer fullEventEntityTransformer;
    @Autowired
    private OutcomeModelTransformer outcomeModelTransformer;
    @Autowired
    private PlayerInfoModelTransformer playerInfoModelTransformer;

    @RequestMapping(value = "/players/{id}", method = RequestMethod.GET)
    public Player getPlayer(@PathVariable int id) {
        return playerService.loadPlayer(id);
    }

    @RequestMapping(value = "/outcomes/{id}", method = RequestMethod.POST)
    public OutcomeModel updateOutcome(@PathVariable(name = "id") int id, @RequestBody OddForm oddForm) {
        Outcome updatedOutcome = eventService.updateOutcome(id, oddEntityTransformer.transform(oddForm));
        return outcomeModelTransformer.transform(updatedOutcome);
    }

    @RequestMapping(value = "/events/add", method = RequestMethod.POST)
    public void updateOutcome(@RequestBody FullEventForm eventForm) {
        eventService.addFullEvent(fullEventEntityTransformer.transform(eventForm));
    }

    @RequestMapping(value = "/events/{eventId}/set-result", method = RequestMethod.POST)
    public void setResult(@PathVariable(name = "eventId") int eventId, @RequestBody List<String> outcomes) {
        eventService.setResult(eventId, outcomes);
    }
    
    @RequestMapping(value = "/playerInfo/{playerId}", method = RequestMethod.GET)
    public PlayerInfoModel servePlayerInfo(@PathVariable(name = "playerId") int playerId) {
        Player player = playerService.loadPlayer(playerId);
        List<Wager> wagers = eventService.loadWagers(playerId);
        SportEvent event = wagers.get(0).getBet().getEvent();
        return playerInfoModelTransformer.transform(player, wagers, event);
    }
}
