package com.example.springboot.testtask.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CommentDTO {
    private Long id;
    private String body;
    private Long postId;
    private UserDTO user;
}
