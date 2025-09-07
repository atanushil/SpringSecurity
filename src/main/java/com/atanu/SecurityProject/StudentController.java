package com.atanu.SecurityProject;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class StudentController {
    private final List<Student> students = new ArrayList<>(List.of(
            new Student(1, "Atanu", 21),
            new Student(2, "Babai", 21)
    ));

    @GetMapping("/students")
    public List<Student> getStudent() {
        return students;
    }

    @GetMapping("/csrf-token")
    public CsrfToken getCsrfToken(HttpServletRequest request) {
        return (CsrfToken) request.getAttribute("_csrf");
    }

    @PostMapping("/students")
    public ResponseEntity<?> addStudent(@RequestBody Student student) {
        for(Student st:students){
            if(st.getId()==student.getId())
                return ResponseEntity.status(400).body("Student already exist");
        }
        students.add(student);
        return ResponseEntity.status(201).body(students);
    }
}

