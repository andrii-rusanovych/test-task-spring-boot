package com.example.test.task.task.service;

import com.example.test.task.task.dto.CommentDTO;
import com.example.test.task.task.dto.CommentResponseDTO;
import com.example.test.task.task.dto.CommentWithUsernameAndUpdatedAtDTO;
import com.example.test.task.task.dto.UserDTO;
import com.example.test.task.task.entity.UserComment;
import com.example.test.task.task.repository.UserCommentRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

@Service
public class UserCommentService {
    @Autowired
    private UserCommentRepository userCommentRepository;

    @PostConstruct
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

    public List<CommentWithUsernameAndUpdatedAtDTO> getAllComments() {
        List<UserComment> userComments = userCommentRepository.findAll();
        List<CommentWithUsernameAndUpdatedAtDTO> commentDTOList = new ArrayList<>();
        for (UserComment userComment: userComments) {

            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d-M-yyyy H:mm:ss");

            String formatDateTime = userComment.getUpdatedAt().format(formatter);

            CommentWithUsernameAndUpdatedAtDTO commentDTO = new CommentWithUsernameAndUpdatedAtDTO();
            commentDTO.setBody(userComment.getBody());
            commentDTO.setId(userComment.getId());
            commentDTO.setPostId(userComment.getPostId());
            commentDTO.setUsername(userComment.getUsername());
            commentDTO.setUpdatedAt(formatDateTime);

            commentDTOList.add(commentDTO);

        }
        return commentDTOList;
    }
}
