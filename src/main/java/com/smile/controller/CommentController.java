package com.smile.controller;

import com.smile.service.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.text.MessageFormat;

@RequiredArgsConstructor
@RequestMapping("/post")
@Controller
public class CommentController {

    private final CommentService commentService;

    @GetMapping("/{postId}/comment")
    public String getPostComments(@PathVariable Long postId, Model model) {
        model.addAttribute("comment", commentService.findAll(postId));
        model.addAttribute("postId", postId);
        return "postComment";
    }

    @PostMapping("/{postId}/comment")
    public String writePostComment(@PathVariable Long postId, @RequestParam String content) {
        commentService.save(postId, content);
        return MessageFormat.format("redirect:/post/{0}/comment", postId);
    }

    @PutMapping("/{postId}/comment/{commentId}")
    public String updatePostComment(@PathVariable Long postId,
                                    @PathVariable Long commentId,
                                    @RequestParam String content) {
        commentService.update(commentId, content);
        return MessageFormat.format("redirect:/post/{0}/comment", postId);
    }

    @DeleteMapping("/{postId}/comment/{commentId}")
    public String deleteComment(@PathVariable Long postId, @PathVariable Long commentId) {
        commentService.delete(commentId);
        return MessageFormat.format("redirect:/post/{0}/comment", postId);
    }

    @GetMapping("/{postId}/comment/{commentId}/return")
    public String updateComment(@PathVariable Long postId,
                                @PathVariable Long commentId,
                                Model model) {
        model.addAttribute("comment", commentService.findOne(commentId));
        model.addAttribute("postId", postId);
        return "commentUpdate";
    }

}
