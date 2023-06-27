package com.example.kitaplikDemo.business.concretes;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.example.kitaplikDemo.business.abstracts.UserService;
import com.example.kitaplikDemo.config.modelmapper.ModelMapperService;
import com.example.kitaplikDemo.dto.requests.BookRequests.UpdateBookRequests;
import com.example.kitaplikDemo.dto.requests.UserRequests.CreateUserRequests;
import com.example.kitaplikDemo.dto.requests.UserRequests.DeleteUserRequests;
import com.example.kitaplikDemo.dto.requests.UserRequests.UpdateUserRequests;
import com.example.kitaplikDemo.dto.responses.User.GetAllUserResponses;
import com.example.kitaplikDemo.model.Book;
import com.example.kitaplikDemo.model.User;
import com.example.kitaplikDemo.repository.UserRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class UserManager implements UserService {

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

    @Override
    public User getOneUser(Long userId) {
        return userRepository.findById(userId).orElse(null);
    }

    @Override
    public void add(CreateUserRequests createUserRequests) {
        User user = modelMapperService.forRequest()
                .map(createUserRequests, User.class);
        this.userRepository.save(user);
    }

    @Override
    public void delete(DeleteUserRequests deleteUserRequest) {
        User user = modelMapperService.forRequest()
                .map(deleteUserRequest, User.class);
        this.userRepository.delete(user);
    }

    @Override
    public void update(UpdateUserRequests updateUserRequests) {
        User inDbUser = userRepository.findById(updateUserRequests.getId()).get();
        User user = new User();
        user.setId(updateUserRequests.getId());
        user.setUserName(updateUserRequests.getUserName());
        user.setPassword(updateUserRequests.getPassword());

    }

}
