package com.epam.training.sportsbetting.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.epam.training.sportsbetting.domain.Player;
import com.epam.training.sportsbetting.domain.Wager;

public interface WagerRepository extends CrudRepository<Wager, Integer> {
    List<Wager> findByPlayer(Player player);
}
