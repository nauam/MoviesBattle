package com.nauam.www.apimoviesbattle.login.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Optional;

import com.nauam.www.apimoviesbattle.user.model.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

public class LoggedInUser implements UserDetails {

    private final Optional<User> user;

    @Autowired
    public LoggedInUser(Optional<User> user) {
        this.user = user;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return new ArrayList<>();
    }

    @Override
    public String getPassword() {
        return user.orElse(new User()).getPassword();
    }

    @Override
    public String getUsername() {
        return user.orElse(new User()).getUsername();
    }

    public String getEmail() {
        return user.orElse(new User()).getEmail();
    }

    public Integer getId() {
        return user.orElse(new User()).getId();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
