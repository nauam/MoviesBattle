package com.nauam.www.apimoviesbattle.login.controller;

import java.util.List;

import javax.validation.Valid;

import com.nauam.www.apimoviesbattle.login.request.SigninRequest;
import com.nauam.www.apimoviesbattle.login.request.SignupRequest;
import com.nauam.www.apimoviesbattle.login.response.SigninResponse;
import com.nauam.www.apimoviesbattle.message.response.FieldMessage;
import com.nauam.www.apimoviesbattle.user.model.User;
import com.nauam.www.apimoviesbattle.user.repository.UserRepository;
import com.nauam.www.apimoviesbattle.user.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {

    private final UserService service;
    private final UserRepository repository;

    @Autowired
    public LoginController(UserService service, UserRepository repository) {
        this.service = service;
        this.repository = repository;
    }

    @GetMapping("/users")
    public ResponseEntity<List<User>> findAll() {
        return ResponseEntity.ok(repository.findAll());
    }

    @PostMapping("/signup")
    public ResponseEntity<?> register(@Valid @RequestBody SignupRequest signupRequest) {
        FieldMessage response = service.register(signupRequest);
        return ResponseEntity.ok(response);
    }

    @PostMapping("/signin")
    public ResponseEntity<?> authenticate(@Valid @RequestBody SigninRequest signinRequest) {
        SigninResponse response = service.authenticate(signinRequest);
        return ResponseEntity.ok(response);
    }
    
}
