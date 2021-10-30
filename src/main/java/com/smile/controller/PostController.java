package com.smile.controller;

import com.smile.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RequiredArgsConstructor
@RequestMapping("/api/v1/post")
@Controller
public class PostController {

    private final PostService postService;

    @GetMapping
    public String main(Model model) {
        model.addAttribute("post", postService.getPostAllByUserId());
        return "main";
    }

    @PostMapping
    public String create(@RequestParam String title,
                         @RequestParam String content) {
        postService.create(title, content);
        return "redirect:/api/v1/post";
    }

    @GetMapping("/return")
    public String writeReturn() {
        return "create";
    }

}
