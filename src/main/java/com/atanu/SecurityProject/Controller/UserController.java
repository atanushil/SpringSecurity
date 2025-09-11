package com.atanu.SecurityProject.Controller;

import com.atanu.SecurityProject.Dto.UserRequestDto;
import com.atanu.SecurityProject.Model.Users;
import com.atanu.SecurityProject.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody UserRequestDto user){
        return userService.registerUser(user);
    }
}
