package com.cmed.repository;


import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cmed.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    // ✅ Custom method for login (Spring Data JPA automatically implements it)
    // User findByUsername(String username);
	
	Optional<User> findByUsername(String username);
    boolean existsByUsername(String username);
}
