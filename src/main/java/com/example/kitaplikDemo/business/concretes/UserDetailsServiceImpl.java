package com.example.kitaplikDemo.business.concretes;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.kitaplikDemo.business.abstracts.UserService;
import com.example.kitaplikDemo.model.User;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.var;

@Service
@AllArgsConstructor
@NoArgsConstructor
public class UserDetailsServiceImpl implements UserDetailsService {

    private UserService userService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        User user = userService.getOneUserByUserName(username);
        var roles = Stream.of(user.getRole())
                .<SimpleGrantedAuthority>map(role -> new SimpleGrantedAuthority(role.name()))

                .collect(Collectors.toList());

        return new org.springframework.security.core.userdetails.User(user.getUserName(), user.getPassword(), roles);

    }

}
