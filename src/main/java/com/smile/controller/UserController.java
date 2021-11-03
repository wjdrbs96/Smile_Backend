package com.smile.controller;

import com.smile.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * created by Gyunny 2021/11/03
 */
@RequiredArgsConstructor
@RequestMapping("/user")
@Controller
public class UserController {

    private final UserService userService;

    @GetMapping
    public String myPage(Model model) {
        model.addAttribute("mypage", userService.findMyPage());
        return "myPage";
    }

}
