package com.example.kitaplikDemo.business.concretes;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.kitaplikDemo.model.User;
import com.example.kitaplikDemo.repository.UserRepository;
import com.example.kitaplikDemo.security.JwtUserDetails;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class UserDetailsServiceImpl implements UserDetailsService {

    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        User user = userRepository.findByUserName(username);

        return JwtUserDetails.create(user);
    }

    public UserDetails loadByUserId(Long id) {
        User user = userRepository.findById(id).get();

        return JwtUserDetails.create(user);
    }

}
