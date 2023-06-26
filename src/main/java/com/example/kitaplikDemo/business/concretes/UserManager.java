package com.example.kitaplikDemo.business.concretes;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.example.kitaplikDemo.business.abstracts.UserService;
import com.example.kitaplikDemo.config.modelmapper.ModelMapperService;
import com.example.kitaplikDemo.dto.responses.GetAllUserResponses;
import com.example.kitaplikDemo.model.User;
import com.example.kitaplikDemo.repository.UserRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class UserManager implements UserService{

    private UserRepository userRepository;
    private ModelMapperService modelMapperService;

    @Override
    public List<GetAllUserResponses> getAllUsers() {

        List<User> users = userRepository.findAll();
        List<GetAllUserResponses> getAllUserResponses = users.stream()
        .map(user -> this.modelMapperService.forResponse()
        .map(user, GetAllUserResponses.class))
        .collect(Collectors.toList());

        return getAllUserResponses;
    }
    
}
