package com.example.demo.entity;

import lombok.Builder;
import lombok.Data;

/**
 * @author wyh
 * @date 2020/5/18 0018
 */
@Data
@Builder
public class user {
    String username;
    String password;

    public user() {
    }

    public user(String username, String password) {
        this.username = username;
        this.password = password;
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

    @Override
    public String toString() {
        return "user{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
