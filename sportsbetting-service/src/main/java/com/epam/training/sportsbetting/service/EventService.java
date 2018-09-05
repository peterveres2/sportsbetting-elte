package com.epam.training.sportsbetting.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.epam.training.sportsbetting.domain.Bet;
import com.epam.training.sportsbetting.domain.Outcome;
import com.epam.training.sportsbetting.domain.OutcomeOdd;
import com.epam.training.sportsbetting.domain.Player;
import com.epam.training.sportsbetting.domain.Result;
import com.epam.training.sportsbetting.domain.SportEvent;
import com.epam.training.sportsbetting.domain.Wager;
import com.epam.training.sportsbetting.repositories.BetRepository;
import com.epam.training.sportsbetting.repositories.OutcomeOddRepository;
import com.epam.training.sportsbetting.repositories.OutcomeRepository;
import com.epam.training.sportsbetting.repositories.PlayerRepository;
import com.epam.training.sportsbetting.repositories.ResultRepository;
import com.epam.training.sportsbetting.repositories.SportEventRepository;
import com.epam.training.sportsbetting.repositories.WagerRepository;

public class EventService {

    @Autowired
    private PlayerRepository playerRepository;
    @Autowired
    private WagerRepository wagerRepository;
    @Autowired
    private SportEventRepository eventRepository;
    @Autowired
    private BetRepository betRepository;
    @Autowired
    private OutcomeRepository outcomeRepository;
    @Autowired
    private OutcomeOddRepository oddRepository;
    @Autowired
    private ResultRepository resultRepository;
    @Autowired
    private ResultEvaluator resultEvaluator;

   

    @Transactional
    public List<Wager> loadWagers(int playerId) {
        return wagerRepository.findByPlayer(playerRepository.findOne(playerId));
    }

    @Transactional
    public void deleteWager(int wagerId) {
        Wager wager = wagerRepository.findOne(wagerId);
        Player player = wager.getPlayer();
        player.setBalance(player.getBalance() + wager.getAmount());
        playerRepository.save(player);
        wagerRepository.delete(wagerId);
    }

    public List<SportEvent> loadEvents() {
        List<SportEvent> events = new ArrayList<>();
        eventRepository.findAll().forEach(events::add);
        return events;
    }

    public List<Bet> loadBets(int eventId) {
        return betRepository.findByEventId(eventId);
    }

    public List<Outcome> loadOutcomes(int betId) {
        return betRepository.findOne(betId).getOutcomes();
    }

    public Bet loadBet(int betId) {
        return betRepository.findOne(betId);
    }

    public OutcomeOdd loadOddByOutcome(int outcomeId) {
        return outcomeRepository.findOne(outcomeId).getLatestOdd();
    }

    public void addWager(Wager wager) {
        wagerRepository.save(wager);
        Player player = wager.getPlayer();
        player.setBalance(player.getBalance() - wager.getAmount());
        playerRepository.save(player);
    }

    public Outcome updateOutcome(int outcomeId, OutcomeOdd odd) {
        Outcome outcome = outcomeRepository.findOne(outcomeId);
        odd.setOutcome(outcome);
        outcome.addOdd(oddRepository.save(odd));
        return outcomeRepository.save(outcome);
    }

    public List<Bet> addFullEvent(List<Bet> bets) {
        List<Bet> savedBets = new ArrayList<>();
        for (Bet bet : bets) {
            savedBets.add(betRepository.save(bet));
        }
        return savedBets;
    }

    public void evaluate(List<Outcome> outcomes) {
        resultEvaluator.evaluate(outcomes);
    }

    @Transactional
    public void setResult(int eventId, List<String> outcomeNames) {
        SportEvent event = eventRepository.findOne(eventId);
        List<Outcome> outcomes = new ArrayList<>();
        for (String outcomeName : outcomeNames) {
            Outcome outcome = outcomeRepository.findOutcomeByValue(outcomeName);
            outcomes.add(outcome);
        }
        Result result = resultRepository.save(new Result(outcomes));
        event.setResult(result);
        eventRepository.save(event);
        evaluate(outcomes);
    }
}
