package com.example.springboot.testtask.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class CommentWithUsernameAndUpdatedAtDTO {
    private Long id;

    private String body;

    private Long postId;

    private String username;

    private String updatedAt;
}
