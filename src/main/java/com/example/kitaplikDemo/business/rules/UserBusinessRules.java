package com.example.kitaplikDemo.business.rules;

import org.springframework.stereotype.Service;

import com.example.kitaplikDemo.core.exceptions.BusinessException;
import com.example.kitaplikDemo.repository.UserRepository;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class UserBusinessRules {

    private UserRepository userRepository;
    
    public void checkIfUserNameExists(String username) {
        if(this.userRepository.existsByUserName(username)) {
            throw new BusinessException("User already exists.");
        }
    }
}
