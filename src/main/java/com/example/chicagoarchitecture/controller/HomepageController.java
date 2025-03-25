package com.example.chicagoarchitecture.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomepageController {

    @GetMapping("/")
    public String homepage(Model model) {
        model.addAttribute("message", "Welcome to Chicago Architecture");
        return "homepage";
    }
}
