package com.nauam.www.apimoviesbattle.security.service;

import java.util.Optional;

import com.nauam.www.apimoviesbattle.security.model.LoggedInUser;
import com.nauam.www.apimoviesbattle.user.model.User;
import com.nauam.www.apimoviesbattle.user.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class LoggedInUserService implements UserDetailsService {

    private final UserRepository repository;

    @Autowired
    public LoggedInUserService(UserRepository repository) {
        this.repository = repository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<User> user = repository.findByUsername(username);
        if (user.isEmpty()) {
            throw new UsernameNotFoundException("Usuário não encontrado!");
        }
        return new LoggedInUser(user);
    }
    
}