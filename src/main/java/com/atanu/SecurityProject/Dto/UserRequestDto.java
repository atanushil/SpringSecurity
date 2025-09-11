package com.atanu.SecurityProject.Dto;

import com.atanu.SecurityProject.Model.Users;

public class UserRequestDto  {
    private String username;
    private String password;
    private int version;

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getVersion() {
        return version;
    }

    public void setVersion(int version) {
        this.version = version;
    }

    public UserRequestDto(String password, String username, int version) {
        this.password = password;
        this.username = username;
        this.version = version;
    }

    public UserRequestDto(String password,String username){
        this.password=password;
        this.username=username;
    }
    public UserRequestDto(){

    }

    @Override
    public String toString() {
        return "User credential : {" +
                "password='" + password + '\'' +
                ", username='" + username + '\'' +
                '}';
    }
}
