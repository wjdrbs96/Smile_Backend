package com.smile.controller;

import com.smile.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
        model.addAttribute("post", postService.findAll());
        return "main";
    }

    @PostMapping
    public String create(@RequestParam String title,
                         @RequestParam String content) {
        postService.save(title, content);
        return "redirect:/api/v1/post";
    }

    // Put 으로 하고 싶은데 html 에서 요청 다시 확인하기..
    @PostMapping("/{postId}")
    public String update(@PathVariable Long postId,
                         @RequestParam String title,
                         @RequestParam String content) {
        postService.update(postId, title, content);
        return "redirect:/api/v1/post";
    }

    @GetMapping("/{postId}/return")
    public String updateReturn(@PathVariable Long postId, @RequestParam("check") int checkId, Model model) {
        model.addAttribute("post", postService.findOneAndIncreaseViews(postId));
        if (checkId == 1) {
            return "view";
        }

        return "update";
    }

    @GetMapping("/return")
    public String writeReturn() {
        return "create";
    }

}
