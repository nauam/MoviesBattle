package com.nauam.www.apimoviesbattle.login.controller;

import javax.validation.Valid;

import com.nauam.www.apimoviesbattle.login.request.SigninRequest;
import com.nauam.www.apimoviesbattle.login.request.SignupRequest;
import com.nauam.www.apimoviesbattle.login.response.Response;
import com.nauam.www.apimoviesbattle.login.response.SigninResponse;
import com.nauam.www.apimoviesbattle.user.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {

    private final UserService service;

    @Autowired
    public LoginController(UserService service) {
        this.service = service;
    }

    @PostMapping("/signin")
    public ResponseEntity<?> authenticate(@Valid @RequestBody SigninRequest signinRequest) {
        SigninResponse response = service.authenticate(signinRequest);
        return ResponseEntity.ok(response);
    }

    @PostMapping("/signup")
    public ResponseEntity<?> register(@Valid @RequestBody SignupRequest signupRequest) {
        Response response = service.register(signupRequest);
        return ResponseEntity.ok(response);
    }
    
}
