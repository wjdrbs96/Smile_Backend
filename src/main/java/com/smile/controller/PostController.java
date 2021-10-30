package com.smile.controller;

import com.smile.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@RequiredArgsConstructor
@Controller
public class PostController {

    private final PostService postService;

    @GetMapping
    public String main(Model model) {
        model.addAttribute("post", postService.getPostAllByUserId());
        return "main";
    }

}
