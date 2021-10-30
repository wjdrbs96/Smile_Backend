package com.smile.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PostController {

    @GetMapping()
    public String test(Model model) {
        model.addAttribute("test", "Gyunny");
        return "test";
    }

}
