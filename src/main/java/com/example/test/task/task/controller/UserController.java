package com.example.test.task.task.controller;

import com.example.test.task.task.entity.UserComment;
import com.example.test.task.task.service.UserCommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class UserController {

    @Autowired
    private UserCommentService userCommentService;

    @GetMapping("/users")
    public String getUsers(Model model) {
        List<UserComment> userComments = userCommentService.getAllComments();
        model.addAttribute("userComments", userComments);
        return "users"; // name of the Thymeleaf template to render
    }
}