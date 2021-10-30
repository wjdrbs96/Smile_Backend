package com.smile.controller;

import com.smile.service.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@RequiredArgsConstructor
@RequestMapping("/api/v1/post")
@Controller
public class CommentController {

    private final CommentService commentService;

    @GetMapping("/{postId}/comment")
    public String getPostComment(@PathVariable Long postId, Model model) {
        model.addAttribute("comment", commentService.findComment(postId));
        return "postComment";
    }

}
