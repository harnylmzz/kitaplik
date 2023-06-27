package com.example.kitaplikDemo.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.kitaplikDemo.business.abstracts.UserService;
import com.example.kitaplikDemo.dto.requests.BookRequests.UpdateBookRequests;
import com.example.kitaplikDemo.dto.requests.UserRequests.CreateUserRequests;
import com.example.kitaplikDemo.dto.requests.UserRequests.DeleteUserRequests;
import com.example.kitaplikDemo.dto.requests.UserRequests.UpdateUserRequests;
import com.example.kitaplikDemo.dto.responses.User.GetAllUserResponses;
import com.example.kitaplikDemo.model.User;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/api/users")
@AllArgsConstructor
public class UsersController {

    private UserService userService;

    @GetMapping("/getall")
    public List<GetAllUserResponses> getAll() {
        return this.userService.getAllUsers();
    }

    @GetMapping("/{userId}")
    public User getOneUser(@PathVariable Long userId) {
        return this.userService.getOneUser(userId);
    }

    @PostMapping("/add")
    @ResponseStatus(code = HttpStatus.CREATED)
    public void add(@RequestBody @Valid CreateUserRequests createUserRequests) {
        this.userService.add(createUserRequests);
    }

    @DeleteMapping("/delete")
    public void delete(DeleteUserRequests deleteUserRequests) {
        this.userService.delete(deleteUserRequests);
    }

    @PutMapping("/update")
    public void update(@RequestBody UpdateUserRequests updateUserRequests) {
        this.userService.update(updateUserRequests);
    }
}
