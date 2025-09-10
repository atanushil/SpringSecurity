package com.atanu.SecurityProject.Model;

import jakarta.persistence.*;

@Entity
@Table(name = "Users")
public class Users {

    @Id
//    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String username;
    private String password;

    @Version
    private Long version;

    public Users() {
    }

    public Users(Long id, String username, String password,Long version) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.version=version;
    }

    // getters and setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Long getVersion() {
        return version;
    }

    public void setVersion(Long version) {
        this.version = version;
    }

    @Override
    public String toString() {
        return "Users{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", version=" + version +
                '}';
    }


}
