package com.atanu.SecurityProject.Repo;

import com.atanu.SecurityProject.Model.Users;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface userRepo extends JpaRepository <Users,Integer> {
    Users findByUsername(String username);
}
