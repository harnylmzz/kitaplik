package com.example.kitaplikDemo.core.exceptions;

public class UserNotFoundException extends RuntimeException {
    public UserNotFoundException(Long userId) {
        super("User not found with id" + userId);
    }
}
