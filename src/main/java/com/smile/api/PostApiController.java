package com.smile.api;

import com.smile.service.PostService;
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
import org.springframework.web.bind.annotation.ResponseBody;

@RequiredArgsConstructor
@RequestMapping("/api/v1/post")
@Controller
public class PostApiController {

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

    @PutMapping("/{postId}")
    public String update(@PathVariable Long postId,
                         @RequestParam String title,
                         @RequestParam String content) {
        postService.update(postId, title, content);
        return "redirect:/api/v1/post";
    }

    @DeleteMapping("/{postId}")
    @ResponseBody
    public String delete(@PathVariable Long postId) {
        postService.delete(postId);
        return "success";
    }

}
