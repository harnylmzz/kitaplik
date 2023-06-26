package com.example.kitaplikDemo.business.abstracts;

import java.util.List;

import com.example.kitaplikDemo.dto.responses.GetAllUserResponses;

public interface UserService {
    List<GetAllUserResponses> getAllUsers();
}
