package com.smile.api;

import com.smile.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequiredArgsConstructor
@RequestMapping("/api/v1/user")
@Controller
public class UserApiController {

    private final UserService userService;

    @GetMapping
    public String myPage(Model model) {
        model.addAttribute("mypage", userService.findMyPage());
        return "myPage";
    }

}
