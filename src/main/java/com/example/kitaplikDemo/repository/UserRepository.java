package com.example.kitaplikDemo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.kitaplikDemo.model.User;


public interface UserRepository extends JpaRepository<User, Long> {

    boolean existsByUserName(String userName);
    List<User> findByUserNameStartingWith(String userName);
    User findByUserName(String userName);    
}
