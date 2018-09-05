package com.epam.training.sportsbetting.repositories;

import org.springframework.data.repository.CrudRepository;

import com.epam.training.sportsbetting.domain.SportEvent;

public interface SportEventRepository extends CrudRepository<SportEvent, Integer> {

}
