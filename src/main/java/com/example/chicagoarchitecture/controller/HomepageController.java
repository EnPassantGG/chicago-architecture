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
        chicagoDistricts.put("Downtown", "downtown");
        chicagoDistricts.put("North Side", "north_side");
        chicagoDistricts.put("West Side", "west_side");
        chicagoDistricts.put("South Side", "south_side");
        chicagoDistricts.put("Suburbs", "suburbs");

        model.addAttribute("chicagoDistricts", chicagoDistricts);

        return "homepage";
    }

    @GetMapping("/about")
    public String aboutPage() {
        return "about";
    }

    @GetMapping("/downtown")
    public String downtownDistrict() {
        return "/chicagoDistricts/downtown";
    }

    @GetMapping("/north_side")
    public String northSideDistrict() {
        return "/chicagoDistricts/north_side";
    }

    @GetMapping("west_side")
    public String westSideDistrict() {
        return "/chicagoDistricts/west_side";
    }

    @GetMapping("south_side")
    public String southSideDistrict() {
        return "/chicagoDistricts/south_side";
    }

    // Try creating another controller and moving this code to
    // the SuburbDistrictController.java file
    @GetMapping("suburbs")
    public String suburbDistrict() {
        return "/chicagoDistricts/suburbs";
    }

}
