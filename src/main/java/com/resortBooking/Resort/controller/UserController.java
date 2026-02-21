package com.resortBooking.Resort.controller;

import com.resortBooking.Resort.models.UserModel;
import com.resortBooking.Resort.service.UserService;
import com.resortBooking.Resort.utility.JWTUtility;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private JWTUtility jWTUtility;

    @PostMapping("/register")
    public String userRegistration(@RequestBody UserModel user){
        return userService.registerUser(user);
    }

    @PostMapping("/login")
    public ResponseEntity<?> userLogin(@RequestBody UserModel user){
        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(user.username(), user.password()));
            String token = jWTUtility.generateJWTToken(user.username());
            return ResponseEntity.ok(Map.of("token", token));
        }
        catch (Exception e){
            e.printStackTrace();
            System.out.println("Invalid user details");
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(Map.of("error", "Invalid User details"));
        }
    }
}
