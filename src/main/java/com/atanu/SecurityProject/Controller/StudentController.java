package com.atanu.SecurityProject.Controller;

import com.atanu.SecurityProject.Dto.StudentRequestDto;
import com.atanu.SecurityProject.Model.Student;
import com.atanu.SecurityProject.Repo.StudentRepo;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@RestController
public class StudentController {
    @Autowired
    private StudentRepo students;

    @GetMapping("/students")
    public List<Student> getStudent() {
        return students.findAll();
    }

    @GetMapping("/csrf-token")
    public CsrfToken getCsrfToken(HttpServletRequest request) {
        return (CsrfToken) request.getAttribute("_csrf");
    }

    @PostMapping("/students")
    public ResponseEntity<?> addStudent(@RequestBody StudentRequestDto student) {
        for(Student st:students.findAll()){
            if(Objects.equals(st.getName(), student.getName()))
                return ResponseEntity.status(400).body("Student already exist");
        }
        Student newStudent=new Student();
        newStudent.setName(student.getName());
        newStudent.setAge(student.getAge());
        students.save(newStudent);
        return ResponseEntity.status(201).body(student);
    }

}

