package com.trexis.employeeallocation.model;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
@Table(name = "app_user")

public class User {

    // Getters and setters
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String username;
    private String password;

    // Parameterless constructor (required by JPA)
    public User() {}

    // Constructor with parameters for username and password
    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

}
