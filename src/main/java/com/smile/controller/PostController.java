package com.smile.controller;

import com.smile.dto.PostResponseDTO;
import com.smile.dto.request.PostCreateRequestDTO;
import com.smile.entity.Category;
import com.smile.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RequiredArgsConstructor
@RequestMapping("/post")
@Controller
public class PostController {

    private final PostService postService;

    @GetMapping
    public String find(Pageable pageable, Model model) {
        Page<PostResponseDTO> postResponseDTOPage = postService.findAll(pageable);
        model.addAttribute("post", postResponseDTOPage.getContent());
        model.addAttribute("paging", postResponseDTOPage);
        return "main";
    }

    // api 용도
    @PostMapping
    public String create(@RequestParam String title,
                         @RequestParam String content,
                         @RequestParam Category category) {
        postService.save(new PostCreateRequestDTO(title, content, category));
        return "redirect:/post";
    }

    @PutMapping("/{postId}")
    public String update(@PathVariable Long postId,
                         @RequestParam String title,
                         @RequestParam String content,
                         @RequestParam Category category,
                         @ModelAttribute("userId") Long userId) {
        postService.update(postId, title, content, category);
        return "redirect:/post";
    }

    @DeleteMapping("/{postId}")
    public String delete(@PathVariable Long postId) {
        postService.delete(postId);
        return "redirect:/post";
    }

    @PostMapping("/search")
    public String search(@RequestParam String type,
                         @RequestParam String keyword,
                         Model model) {
        model.addAttribute("post", postService.findSearch(type, keyword));
        return "main";
    }

    @GetMapping("/return")
    public String writeReturn() {
        return "create";
    }

    @GetMapping("/{postId}/return")
    public String updateReturn(@PathVariable Long postId, @RequestParam("check") int checkId, Model model) {
        model.addAttribute("post", postService.findOneAndIncreaseViews(postId));
        if (checkId == 1) {
            return "view";
        }

        return "update";
    }

}
