package com.nauam.www.apimoviesbattle.security.model;

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

    public Integer getId() {
        return user.orElse(new User()).getId();
    }

    @Override
    public String getUsername() {
        return user.orElse(new User()).getUsername();
    }

    @Override
    public String getPassword() {
        return user.orElse(new User()).getPassword();
    }

    public String getEmail() {
        return user.orElse(new User()).getEmail();
    }
    
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
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