package com.atanu.SecurityProject.Repo;

import com.atanu.SecurityProject.Model.Users;


import org.jetbrains.annotations.NotNull;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface userRepo extends JpaRepository <Users,Long> {
    Users findByUsername(String username);
    @NotNull Optional<Users> findById(@NotNull Long id);
}
