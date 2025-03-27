package com.example.chicagoarchitecture.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.LinkedHashMap;

@Controller
public class HomepageController {

    @GetMapping("/")
    public String homePage(Model model) {
        // List of Chicago districts with respective webpages
        LinkedHashMap<String, String> chicagoDistricts = new LinkedHashMap<>();
        chicagoDistricts.put("Downtown (coming soon)", "downtown");
        chicagoDistricts.put("North Side (coming soon)", "north_side");
        chicagoDistricts.put("West Side (coming soon)", "west_side");
        chicagoDistricts.put("South Side (coming soon)", "south_side");
        chicagoDistricts.put("Suburbs", "suburbs");

        model.addAttribute("chicagoDistricts", chicagoDistricts);

        return "homepage";
    }


    @GetMapping("/downtown")
    public String downtownDistrict() {
        return "/chicagoDistricts/downtown";
    }

    @GetMapping("/north_side")
    public String northSideDistrict() {
        return "/chicagoDistricts/north_side";
    }

    @GetMapping("/west_side")
    public String westSideDistrict() {
        return "/chicagoDistricts/west_side";
    }

    @GetMapping("/south_side")
    public String southSideDistrict() {
        return "/chicagoDistricts/south_side";
    }


    @GetMapping("/about")
    public String aboutPage() {
        return "about";
    }

    @GetMapping("/personal_recommendations")
    public String personalFindingsPage() {
        return "personal_recommendations";
    }

}
