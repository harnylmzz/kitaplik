package com.example.kitaplikDemo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.kitaplikDemo.model.User;

public interface UserRepository extends JpaRepository<User, Long> {
    
}
