package com.appl.entities;


import org.springframework.context.annotation.ComponentScan;

import javax.persistence.*;
import javax.validation.constraints.NotNull;


@Entity
@ComponentScan
@Table(name = "LOGINUSER")
public class LoginUser {
    public LoginUser(){}
    public LoginUser(String username, String password) {
        this.username = username;
        this.password = password;
    }

    @Id
    @GeneratedValue
    int id;

    @Column(unique = true,nullable = false,length = 30)
    @NotNull
    String username;

    @Column(nullable = false,length = 30)
    @NotNull
    String password;

    @Override
    public String toString() {
        return "LoginUser{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
