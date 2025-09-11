package com.atanu.SecurityProject.Service;

import com.atanu.SecurityProject.Dto.UserRequestDto;
import com.atanu.SecurityProject.Model.Users;
import com.atanu.SecurityProject.Repo.userRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserService {

    @Autowired
    private userRepo userRepo;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtService jwtService;

    @Transactional
    public ResponseEntity<?> registerUser(UserRequestDto userDto) {
        if (userDto.getUsername() == null || userDto.getUsername().isBlank() ||
                userDto.getPassword() == null || userDto.getPassword().isBlank()) {
            return ResponseEntity.badRequest().body("Please fill all fields");
        }

        if (userRepo.findByUsername(userDto.getUsername())!=null) {
            return ResponseEntity.status(409).body("Username already exists");
        }
        Users newUser=new Users();
        newUser.setUsername(userDto.getUsername());
        newUser.setPassword(passwordEncoder.encode(userDto.getPassword()));
        newUser.setVersion(userDto.getVersion());
        Users savedUser=userRepo.save(newUser);

        return ResponseEntity.status(201).body("User registered with ID: " + savedUser.getId());
    }

    public String verify(UserRequestDto user) {
        Authentication authentication=authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
                user.getUsername(),user.getPassword()
        ));
        if(authentication.isAuthenticated()) return jwtService.generateToken(user);
        return "Fail";
    }
}
