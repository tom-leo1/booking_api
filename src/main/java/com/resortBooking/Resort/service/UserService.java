package com.resortBooking.Resort.service;

import com.resortBooking.Resort.models.UserModel;
import com.resortBooking.Resort.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Collections;

@Service
public class UserService implements UserDetailsService {


    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;





    public String registerUser(UserModel user){
        String encodedPassword = passwordEncoder.encode(user.password());
        UserModel newUser = new UserModel(null, user.username(),encodedPassword, Collections.emptyList());
        userRepository.save(newUser);
        return "User Registered!!";
    }

    public UserModel loginUser(String username){
        return userRepository.findByUsername(username);
    }


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserModel userDetails = loginUser(username);
        return User.builder()
                .username(userDetails.username())
                .password(userDetails.password())
                .build();
    }
}
