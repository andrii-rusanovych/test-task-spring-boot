package com.example.test.task.task.entity;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.Id;

import java.time.LocalDateTime;

@Entity
@Table(name = "users")
public class UserComment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String body;

    private Long postId;

    private String username;

    private LocalDateTime updatedAt;

    public UserComment(Long id, String body, Long postId, String username, LocalDateTime updatedAt) {
        this.id = id;
        this.body = body;
        this.postId = postId;
        this.username = username;
        this.updatedAt = updatedAt;
    }

    public UserComment() {

    }

    public Long getId() {
        return id;
    }

    public String getBody() {
        return body;
    }

    public Long getPostId() {
        return postId;
    }

    public String getUsername() {
        return username;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public void setPostId(Long postId) {
        this.postId = postId;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }
}
