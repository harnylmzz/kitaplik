package com.example.kitaplikDemo.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.kitaplikDemo.business.abstracts.UserService;
import com.example.kitaplikDemo.dto.responses.GetAllUserResponses;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/api/users")
@AllArgsConstructor
public class UsersController {
    
    private UserService userService;

    @GetMapping("/getall")
    public List<GetAllUserResponses> getAll(){
        return this.userService.getAllUsers();
    }
    

}
