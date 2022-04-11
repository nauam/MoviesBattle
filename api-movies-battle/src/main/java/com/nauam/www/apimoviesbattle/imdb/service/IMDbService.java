package com.nauam.www.apimoviesbattle.imdb.service;

import java.io.IOException;

import com.nauam.www.apimoviesbattle.imdb.repository.IMDbRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class IMDbService {
    
    private final WebScrapping webScrapping;
	private final IMDbRepository repository;

    @Autowired
    public IMDbService(IMDbRepository repository, WebScrapping webScrapping) {
        this.webScrapping = webScrapping;
		this.repository = repository;
    }

	public void charge() throws IOException {
		repository.saveAll(webScrapping.scrapping());
	}

}
