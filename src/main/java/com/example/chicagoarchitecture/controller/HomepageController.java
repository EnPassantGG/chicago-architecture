package com.example.chicagoarchitecture.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Arrays;
import java.util.List;

@Controller
public class HomepageController {

    @GetMapping("/")
    public String homepage(Model model) {
        model.addAttribute("message", "Welcome to Chicago Architecture");

        List<String> downtownMillenniumPark = Arrays.asList(
                "Crown Fountain",
                "Cloud Gate",
                "Jay Pritzker Pavilion",
                "Harris Theater for Music and Dance",
                "McDonald's Cycle Center",
                "Lurie Garden",
                "Exelon Pavilions",
                "Modern Wing at the Art Institute of Chicago",
                "BP Pedestrian Bridge",
                "Maggie Daley Park"
                );
        model.addAttribute("millenniumPark", downtownMillenniumPark);

        return "homepage";
    }
}
