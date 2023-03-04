package com.example.test.task.task.service;

import com.example.test.task.task.dto.CommentDTO;
import com.example.test.task.task.dto.CommentResponseDTO;
import com.example.test.task.task.entity.UserComment;
import com.example.test.task.task.repository.UserCommentRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class UserCommentService {
    @Autowired
    private UserCommentRepository userCommentRepository;

    public void fetchAndSaveUserComments() throws JsonProcessingException {
        RestTemplate restTemplate = new RestTemplate();
        String url = "https://dummyjson.com/comments";
        ResponseEntity<String> responseEntity = restTemplate.getForEntity(url, String.class);
        String response = responseEntity.getBody();

        ObjectMapper objectMapper = new ObjectMapper();
        CommentResponseDTO commentResponseDTO = objectMapper.readValue(response, CommentResponseDTO.class);

        for (CommentDTO commentDTO : commentResponseDTO.getComments()) {
            String username = commentDTO.getUser().getUsername();
            UserComment userComment = new UserComment(
                    commentDTO.getId(),
                    commentDTO.getBody(),
                    commentDTO.getPostId(),
                    StringUtils.capitalize(username.substring(0, 1)) + username.substring(1),
                    LocalDateTime.now()
            );
            userCommentRepository.save(userComment);
        }
    }

    public List<UserComment> getAllComments() {
        return userCommentRepository.findAll();
    }
}
