package com.atanu.SecurityProject;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import jakarta.servlet.http.HttpServletRequest;
@RestController
public class HelloController {

    @GetMapping("/")
    public String greet(HttpServletRequest req){
        return "Welcome to my application" +req.getSession().getId();
    }
}
