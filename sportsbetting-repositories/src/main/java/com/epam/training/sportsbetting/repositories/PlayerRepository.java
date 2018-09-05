package com.epam.training.sportsbetting.repositories;

import org.springframework.data.repository.CrudRepository;

import com.epam.training.sportsbetting.domain.Player;

public interface PlayerRepository extends CrudRepository<Player, Integer> {

}
