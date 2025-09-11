package com.atanu.SecurityProject.Service;

import com.atanu.SecurityProject.Dto.UserRequestDto;
import org.springframework.stereotype.Service;

@Service
public class JwtService {
    public String generateToken(UserRequestDto user) {
        return "Token is generated";
    }
}
