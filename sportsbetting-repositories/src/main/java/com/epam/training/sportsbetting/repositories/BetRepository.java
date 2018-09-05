package com.epam.training.sportsbetting.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.epam.training.sportsbetting.domain.Bet;

public interface BetRepository extends CrudRepository<Bet, Integer> {
    List<Bet> findByEventId(int eventId);
}
