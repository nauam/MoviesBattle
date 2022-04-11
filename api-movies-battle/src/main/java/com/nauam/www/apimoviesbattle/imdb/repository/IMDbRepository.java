package com.nauam.www.apimoviesbattle.imdb.repository;

import java.util.Optional;

import com.nauam.www.apimoviesbattle.imdb.model.IMDb;

import org.springframework.transaction.annotation.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IMDbRepository extends JpaRepository<IMDb, Integer> {

	@Transactional(readOnly = true)
    public Optional<IMDb> findByRanking(String ranking);

	@Transactional(readOnly = true)
    public Optional<IMDb> findByRating(String rating);

	@Transactional(readOnly = true)
    public Optional<IMDb> findByName(String name);
}