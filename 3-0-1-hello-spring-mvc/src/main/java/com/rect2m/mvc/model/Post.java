package com.rect2m.mvc.model;

import com.rect2m.mvc.model.User;
import java.time.LocalDateTime;
import java.util.UUID;

public class Post {
    private int id;
    private String title;
    private String text;
    private LocalDateTime createdOn;
    private com.rect2m.mvc.model.User author;

    // Геттери і сеттери
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    // Конструктор
    public Post() {
    }

    public String getTitle() {
        return title;
    }

    public String getText() {
        return text;
    }

    public LocalDateTime getCreatedOn() {
        return createdOn;
    }

    public com.rect2m.mvc.model.User getAuthor() {
        return author; // Геттер для автора
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setText(String text) {
        this.text = text;
    }

    public void setCreatedOn(LocalDateTime createdOn) {
        this.createdOn = createdOn;
    }

    public void setAuthor(User author) { // Сеттер для автора
        this.author = author;
    }
}