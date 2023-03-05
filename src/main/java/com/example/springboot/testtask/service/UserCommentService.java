package com.example.springboot.testtask.service;

import com.example.springboot.testtask.dto.CommentWithUsernameAndUpdatedAtDTO;

import java.util.List;

public interface UserCommentService {
    List<CommentWithUsernameAndUpdatedAtDTO> getAllComments();
}
