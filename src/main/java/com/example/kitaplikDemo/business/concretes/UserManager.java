package com.example.kitaplikDemo.business.concretes;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.example.kitaplikDemo.business.abstracts.UserService;
import com.example.kitaplikDemo.business.rules.UserBusinessRules;
import com.example.kitaplikDemo.config.modelmapper.ModelMapperService;
import com.example.kitaplikDemo.core.exceptions.DataNotFoundException;
import com.example.kitaplikDemo.core.result.DataResult;
import com.example.kitaplikDemo.core.result.Result;
import com.example.kitaplikDemo.core.result.SuccessResult;
import com.example.kitaplikDemo.dto.requests.userRequests.CreateUserRequests;
import com.example.kitaplikDemo.dto.requests.userRequests.DeleteUserRequests;
import com.example.kitaplikDemo.dto.requests.userRequests.UpdateUserRequests;
import com.example.kitaplikDemo.dto.responses.user.GetAllUserResponses;
import com.example.kitaplikDemo.model.User;
import com.example.kitaplikDemo.repository.UserRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class UserManager implements UserService {

    private UserRepository userRepository;
    private ModelMapperService modelMapperService;
    private UserBusinessRules userBusinessRules;

    @Override
    public DataResult<List<GetAllUserResponses>> getAllUsers() {

        List<User> users = userRepository.findAll();
        List<GetAllUserResponses> getAllUserResponses = users.stream()
                .map(user -> this.modelMapperService.forResponse()
                        .map(user, GetAllUserResponses.class))
                .collect(Collectors.toList());

        return new DataResult<List<GetAllUserResponses>>(getAllUserResponses, true, "All users were brought.");
    }

    @Override
    public DataResult<User> getOneUser(Long userId) {

        User user = userRepository.findById(userId).orElseThrow(() -> new DataNotFoundException("User not found!"));
        return new DataResult<User>(user, true, "The user brought.");
    }

    @Override
    public Result add(CreateUserRequests createUserRequests) {

        this.userBusinessRules.checkIfUserNameExists(createUserRequests.getUserName());

        User user = modelMapperService.forRequest()
                .map(createUserRequests, User.class);
        this.userRepository.save(user);
        return new SuccessResult("The user added.");
    }

    @Override
    public Result delete(DeleteUserRequests deleteUserRequest) {
        User user = modelMapperService.forRequest()
                .map(deleteUserRequest, User.class);
        this.userRepository.delete(user);
        return new SuccessResult("The user deleted");
    }

    @Override
    public Result update(UpdateUserRequests updateUserRequests) {

        Optional<User> inDbUser = userRepository.findById(updateUserRequests.getId());

        if (inDbUser.isPresent()) {

            User user = inDbUser.get();

            user.setUserName(updateUserRequests.getUserName());
            user.setPassword(updateUserRequests.getPassword());

            this.userRepository.save(user);
        } else {
        }
        return new SuccessResult("The user updated.");
    }

    @Override
    public User getOneUserByUserName(String userName) {

        return userRepository.findByUserName(userName);
    }

}
