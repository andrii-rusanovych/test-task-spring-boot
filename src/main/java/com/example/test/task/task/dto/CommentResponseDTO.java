package com.example.test.task.task.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
public class CommentResponseDTO {
    private List<CommentDTO> comments;
    private int total;
    private int skip;
    private int limit;
}
