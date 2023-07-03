package com.example.kitaplikDemo.business.abstracts;

import java.util.List;

import com.example.kitaplikDemo.core.result.DataResult;
import com.example.kitaplikDemo.core.result.Result;
import com.example.kitaplikDemo.dto.requests.UserRequests.CreateUserRequests;
import com.example.kitaplikDemo.dto.requests.UserRequests.DeleteUserRequests;
import com.example.kitaplikDemo.dto.requests.UserRequests.UpdateUserRequests;
import com.example.kitaplikDemo.dto.responses.User.GetAllUserResponses;
import com.example.kitaplikDemo.model.User;

public interface UserService {
    DataResult<List<GetAllUserResponses>> getAllUsers();
    DataResult<User> getOneUser(Long userId); 
    Result add(CreateUserRequests createUserRequests);
    Result delete(DeleteUserRequests deleteUserRequest);
    Result update(UpdateUserRequests updateUserRequests);
}
