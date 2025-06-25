package com.example.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "users") // ✅ avoid reserved word
public class User {

    @Id
    private Long id;

    private String name;

    public User() {}

    public User(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    // Getters & Setters
    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }
}
