package com.nauam.www.apimoviesbattle.login.security;

import java.util.Date;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.nauam.www.apimoviesbattle.login.model.LoggedInUser;
import com.nauam.www.apimoviesbattle.login.request.SigninRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

public class JWTAuthenticationFilter extends UsernamePasswordAuthenticationFilter {

    public static final int TOKEN_EXPIRATION = 600_000;
    public static final String TOKEN_PASSWORD = "7b91c5d9-21c1-430a-8756-9bd1c5207fca"; //Por segurança o TOKEN_PASSWORD deve está em um arquivo de configuração.

    @Autowired
    private static AuthenticationManager authenticationManager;

    public JWTAuthenticationFilter(AuthenticationManager authenticationManager) {
        JWTAuthenticationFilter.authenticationManager = authenticationManager;
    }
    
    @Bean
    public static Authentication authentication(SigninRequest user) throws AuthenticationException {
        return authenticationManager.authenticate(
            new UsernamePasswordAuthenticationToken( user.getUsername(), user.getPassword() )
        );
    }

    @Bean
    public static String token(Authentication authentication) throws AuthenticationException {
        LoggedInUser userDetails = (LoggedInUser) authentication.getPrincipal();

        return JWT.create()
            .withSubject(userDetails.getUsername())
            .withExpiresAt(new Date(System.currentTimeMillis() + TOKEN_EXPIRATION))
            .sign(Algorithm.HMAC512(TOKEN_PASSWORD));
    }
}
