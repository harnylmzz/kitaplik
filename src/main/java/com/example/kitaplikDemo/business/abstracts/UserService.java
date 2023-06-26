package com.example.kitaplikDemo.business.abstracts;

import java.util.List;

import com.example.kitaplikDemo.dto.requests.UserRequests.CreateUserRequests;
import com.example.kitaplikDemo.dto.responses.User.GetAllUserResponses;
import com.example.kitaplikDemo.model.User;

public interface UserService {
    List<GetAllUserResponses> getAllUsers();
    User getOneUser(Long userId); 
    void add(CreateUserRequests createUserRequests);
}
