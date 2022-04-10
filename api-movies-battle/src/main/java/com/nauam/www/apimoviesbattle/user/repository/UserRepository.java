package com.nauam.www.apimoviesbattle.user.repository;

import java.util.Optional;

import com.nauam.www.apimoviesbattle.user.model.User;

import org.springframework.transaction.annotation.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

	@Transactional(readOnly = true)
    public Optional<User> findByUsername(String username);

	@Transactional(readOnly = true)
    public Optional<User> findByEmail(String email);
    
}
