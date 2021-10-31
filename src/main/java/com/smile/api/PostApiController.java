package com.smile.api;

import com.smile.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import static com.smile.entity.Paging.createPaging;

@RequiredArgsConstructor
@RequestMapping("/api/v1/post")
@Controller
public class PostApiController {

    private final PostService postService;

    @GetMapping
    public String main(@RequestParam(defaultValue = "1") int page,
                       @RequestParam(defaultValue = "7") int pageSize,
                       Model model) {
        PageRequest paging = PageRequest.of(page - 1, pageSize);
        model.addAttribute("post", postService.findAllByUserOrderByIdDesc(paging));
        model.addAttribute("paging", createPaging(page, pageSize, (postService.count() / pageSize) + 1));
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
    public String delete(@PathVariable Long postId) {
        postService.delete(postId);
        return "redirect:/api/v1/post";
    }

}
