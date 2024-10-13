package com.rect2m.mvc.model;

import java.util.UUID;

public class User {
    private UUID id;
    private String username;

    // Конструктор
    public User() {
    }

    // Геттери
    public UUID getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    // Сеттери
    public void setId(UUID id) {
        this.id = id;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}

