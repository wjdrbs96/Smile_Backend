package com.smile.api;

import com.smile.service.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.text.MessageFormat;

@RequiredArgsConstructor
@RequestMapping("/api/v1/post")
@Controller
public class CommentApiController {

    private final CommentService commentService;

    @GetMapping("/{postId}/comment")
    public String getPostComment(@PathVariable Long postId, Model model) {
        model.addAttribute("comment", commentService.findComment(postId));
        model.addAttribute("postId", postId);
        return "postComment";
    }

    @PostMapping("/{postId}/comment")
    public String writePostComment(@PathVariable Long postId, @RequestParam String content) {
        commentService.save(postId, content);
        return MessageFormat.format("redirect:/api/v1/post/{0}/comment", postId);
    }

    @DeleteMapping("/{postId}/comment/{commentId}")
    public String deleteComment(@PathVariable Long postId, @PathVariable Long commentId) {
        commentService.deleteComment(commentId);
        return MessageFormat.format("redirect:/api/v1/post/{0}/comment", postId);
    }

}
