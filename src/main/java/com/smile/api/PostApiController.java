package com.smile.api;

import com.smile.dto.PostResponseDTO;
import com.smile.entity.Category;
import com.smile.entity.Paging;
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
public class PostApiController {

    private final PostService postService;

    @GetMapping
    public String find(Pageable pageable, Model model) {
        Page<PostResponseDTO> postResponseDTOPage = postService.findAll(pageable);
        model.addAttribute("post", postResponseDTOPage.getContent());
        model.addAttribute("paging", postResponseDTOPage);
        return "main";
    }

    @PostMapping
    public String create(@RequestParam String title,
                         @RequestParam String content,
                         @RequestParam Category category) {
        postService.save(title, content, category);
        return "redirect:/api/v1/post";
    }

    @PutMapping("/{postId}")
    public String update(@PathVariable Long postId,
                         @RequestParam String title,
                         @RequestParam String content,
                         @RequestParam Category category,
                         @ModelAttribute("userId") Long userId) {
        postService.update(postId, title, content, category);
        return "redirect:/api/v1/post";
    }

    @DeleteMapping("/{postId}")
    public String delete(@PathVariable Long postId) {
        postService.delete(postId);
        return "redirect:/api/v1/post";
    }

    @PostMapping("/search")
    public String search(@RequestParam String type,
                         @RequestParam String keyword,
                         Model model) {
        model.addAttribute("post", postService.findSearch(type, keyword));
        return "main";
    }

}
