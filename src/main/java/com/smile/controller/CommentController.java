package com.smile.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/post")
@Controller
public class CommentController {

    @GetMapping("/{postId}/comment/return")
    public String returnCommentView(@PathVariable Long postId, Model model) {
        model.addAttribute("postId", postId);
        return "writeComment";
    }

}
