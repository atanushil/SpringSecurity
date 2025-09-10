package com.atanu.SecurityProject.Service;

import com.atanu.SecurityProject.Model.Users;
import com.atanu.SecurityProject.Repo.userRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserService {

    @Autowired
    private userRepo userRepo;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @Transactional
    public ResponseEntity<?> registerUser(Users user) {
        // Check required fields
        if (user.getUsername() == null || user.getUsername().isBlank() ||
                user.getPassword() == null || user.getPassword().isBlank()) {
            return ResponseEntity.badRequest().body("Please fill all fields");
        }

        // Check if username already exists
        if (userRepo.findById(user.getId()).isPresent()) {
            return ResponseEntity.status(409).body("Username already exists");
        }

        // Hash the password before saving
        user.setPassword(passwordEncoder.encode(user.getPassword()));

        // Save the user
        Users savedUser = userRepo.save(user);

        return ResponseEntity.status(201).body("User registered with ID: " + savedUser.getId());
    }
}
