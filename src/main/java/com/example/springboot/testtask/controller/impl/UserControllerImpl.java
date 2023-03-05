package com.example.springboot.testtask.controller.impl;

import com.example.springboot.testtask.controller.UserController;
import com.example.springboot.testtask.dto.CommentWithUsernameAndUpdatedAtDTO;
import com.example.springboot.testtask.service.UserCommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class UserControllerImpl implements UserController {

    @Autowired
    private UserCommentService userCommentService;

    @GetMapping("/users")
    public String getUsers(Model model) {
        List<CommentWithUsernameAndUpdatedAtDTO> comments = userCommentService.getAllComments();
        model.addAttribute("comments", comments);
        return "userComments";
    }
}