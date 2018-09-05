package com.epam.training.sportsbetting.repositories;

import org.springframework.data.repository.CrudRepository;

import com.epam.training.sportsbetting.domain.User;

public interface UserRepository extends CrudRepository<User, Integer> {
    User findByUsername(String username);
}
