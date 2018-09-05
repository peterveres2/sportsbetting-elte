package com.epam.training.sportsbetting.repositories;

import org.springframework.data.repository.CrudRepository;

import com.epam.training.sportsbetting.domain.Outcome;

public interface OutcomeRepository extends CrudRepository<Outcome, Integer> {
    Outcome findOutcomeByValue(String value);
}
