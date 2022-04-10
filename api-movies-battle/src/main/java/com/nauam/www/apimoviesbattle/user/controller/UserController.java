package com.nauam.www.apimoviesbattle.user.controller;

import java.util.List;

import javax.validation.Valid;

import com.nauam.www.apimoviesbattle.user.dto.UserDTO;
import com.nauam.www.apimoviesbattle.user.model.User;
import com.nauam.www.apimoviesbattle.user.repository.UserRepository;
import com.nauam.www.apimoviesbattle.user.service.validation.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    private final UserService service;
    private final UserRepository repository;
    private final PasswordEncoder encoder;

    @Autowired
    public UserController(UserService service, UserRepository repository, PasswordEncoder encoder) {
        this.service = service;
        this.repository = repository;
        this.encoder = encoder;
    }

    @GetMapping("/users")
    public ResponseEntity<List<User>> findAll() {
        return ResponseEntity.ok(repository.findAll());
    }

    @PostMapping("/signup")
    public ResponseEntity<User> save(@Valid @RequestBody UserDTO userDTO) {
        User user = service.fromDTO(userDTO);
        user.setPassword(encoder.encode(user.getPassword()));
        return ResponseEntity.ok(repository.save(user));
    }
    
}
