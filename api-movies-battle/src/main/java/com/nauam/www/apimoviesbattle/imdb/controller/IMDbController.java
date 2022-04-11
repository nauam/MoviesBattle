package com.nauam.www.apimoviesbattle.imdb.controller;

import java.io.IOException;
import java.util.List;

import com.nauam.www.apimoviesbattle.imdb.model.IMDb;
import com.nauam.www.apimoviesbattle.imdb.repository.IMDbRepository;
import com.nauam.www.apimoviesbattle.imdb.service.IMDbService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/imdb")
public class IMDbController {

	private final IMDbService service;
	private final IMDbRepository repository;

    @Autowired
    public IMDbController(IMDbService service, IMDbRepository repository) {
        this.service = service;
		this.repository = repository;
    }
    
    @PostMapping("/charge")
    public ResponseEntity<List<IMDb>> list() throws IOException {
        service.charge();
        return ResponseEntity.ok(repository.findAll());
    }
    
}