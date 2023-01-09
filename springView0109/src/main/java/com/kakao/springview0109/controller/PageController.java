package com.kakao.springview0109.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PageController {
    @GetMapping("/")
    public String main(Model model){
        model.addAttribute("message", "Spring Boot 에서의 JSP");
        return "main";
    }
}
