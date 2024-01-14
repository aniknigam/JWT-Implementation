package com.learn.GFGjwt.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.learn.GFGjwt.entity.User;


public interface UserRepo extends JpaRepository<User, Integer> {

	Optional<User> findByName(String username);
    // You can add custom query methods here if needed
}
