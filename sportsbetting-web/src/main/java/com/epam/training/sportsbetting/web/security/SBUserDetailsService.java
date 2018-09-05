package com.epam.training.sportsbetting.web.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.epam.training.sportsbetting.domain.User;
import com.epam.training.sportsbetting.service.PlayerService;

@Service
public class SBUserDetailsService implements UserDetailsService {

    @Autowired
    private PlayerService service;

    @Override
    public UserDetails loadUserByUsername(String username) {
        User user = service.findUser(username);
        if (user == null) {
            throw new UsernameNotFoundException(username);
        }
        return new SBUserPrincipal(user);
    }
}
