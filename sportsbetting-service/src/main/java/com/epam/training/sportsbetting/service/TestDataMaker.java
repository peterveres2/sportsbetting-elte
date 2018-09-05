package com.epam.training.sportsbetting.service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.epam.training.sportsbetting.domain.Bet;
import com.epam.training.sportsbetting.domain.BetType;
import com.epam.training.sportsbetting.domain.FootballSportEvent;
import com.epam.training.sportsbetting.domain.Outcome;
import com.epam.training.sportsbetting.domain.OutcomeOdd;
import com.epam.training.sportsbetting.domain.Result;
import com.epam.training.sportsbetting.domain.SportEvent;
import com.epam.training.sportsbetting.repositories.BetRepository;
import com.epam.training.sportsbetting.repositories.OutcomeOddRepository;
import com.epam.training.sportsbetting.repositories.OutcomeRepository;
import com.epam.training.sportsbetting.repositories.ResultRepository;
import com.epam.training.sportsbetting.repositories.SportEventRepository;

public class TestDataMaker {
    private SportEvent event;
    private List<Outcome> outcomes;
    private List<Outcome> outcomes2;
    private Bet bet;
    private Bet bet2;

    @Autowired
    private BetRepository betRepository;
    @Autowired
    private OutcomeRepository outcomeRepository;
    @Autowired
    private OutcomeOddRepository outcomeOddRepository;
    @Autowired
    private SportEventRepository sportEventRepository;
    @Autowired
    private ResultRepository resultRepository;

    @Transactional
    public void generateData() {
        event = new FootballSportEvent("Fradi vs UTE",
                LocalDateTime.now(),
                LocalDateTime.now().plusHours(2));
        Outcome testOutcome1 = new Outcome("Fradi wins");
        Outcome testOutcome2 = new Outcome("Draw");
        Outcome testOutcome3 = new Outcome("UTE wins");
        Outcome testOutcome4 = new Outcome("1 goal");
        Outcome testOutcome5 = new Outcome("2 goals");
        Outcome testOutcome6 = new Outcome("3 goals");
        OutcomeOdd testOdd1 = new OutcomeOdd(10.0f, LocalDate.now(), LocalDate.now().plusDays(2), testOutcome1);
        OutcomeOdd testOdd2 = new OutcomeOdd(3.2f, LocalDate.now(), LocalDate.now().plusDays(1), testOutcome2);
        OutcomeOdd testOdd3 = new OutcomeOdd(1.2f, LocalDate.now(), LocalDate.now().plusDays(1), testOutcome3);
        OutcomeOdd testOdd4 = new OutcomeOdd(10.0f, LocalDate.now(), LocalDate.now().plusDays(2), testOutcome4);
        OutcomeOdd testOdd5 = new OutcomeOdd(3.2f, LocalDate.now(), LocalDate.now().plusDays(1), testOutcome5);
        OutcomeOdd testOdd6 = new OutcomeOdd(1.2f, LocalDate.now(), LocalDate.now().plusDays(1), testOutcome6);
        testOutcome1.addOdd(testOdd1);
        testOutcome2.addOdd(testOdd2);
        testOutcome3.addOdd(testOdd3);
        testOutcome4.addOdd(testOdd4);
        testOutcome5.addOdd(testOdd5);
        testOutcome6.addOdd(testOdd6);
        outcomes = Arrays.asList(testOutcome1, testOutcome2, testOutcome3);
        bet = new Bet(event, outcomes, "Fradi Ute win bet", BetType.WIN_BET);
        outcomes2 = Arrays.asList(testOutcome4, testOutcome5, testOutcome6);
        bet2 = new Bet(event, outcomes2, "Fradi Ute goals bet", BetType.ALL_GOALS_BET);
        sportEventRepository.save(event);
        outcomeRepository.save(testOutcome1);
        outcomeRepository.save(testOutcome2);
        outcomeRepository.save(testOutcome3);
        outcomeRepository.save(testOutcome4);
        outcomeRepository.save(testOutcome5);
        outcomeRepository.save(testOutcome6);
        outcomeOddRepository.save(testOdd1);
        outcomeOddRepository.save(testOdd2);
        outcomeOddRepository.save(testOdd3);
        betRepository.save(bet);
        betRepository.save(bet2);
    }

    @Transactional
    public void generateResult() {
        int randNum = (int) (Math.random() * outcomes.size());
        List<Outcome> winningOutcomes = new ArrayList<Outcome>();
        winningOutcomes.add(outcomes.get(randNum));
        randNum = (int) (Math.random() * outcomes2.size());
        winningOutcomes.add(outcomes2.get(randNum));
        Result result = new Result(winningOutcomes);
        resultRepository.save(result);
    }
}
