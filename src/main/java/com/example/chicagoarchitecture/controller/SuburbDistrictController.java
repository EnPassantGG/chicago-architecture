package com.example.chicagoarchitecture.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.LinkedHashMap;

@Controller
@RequestMapping("/suburbs")
public class SuburbDistrictController {

    // Main section pertaining the suburbs
    @GetMapping
    public String suburbDistrict(Model model) {

        LinkedHashMap<String, String> suburbsSubDistricts = new LinkedHashMap<>();
        suburbsSubDistricts.put("North Suburbs", "north_suburbs");
        suburbsSubDistricts.put("Northwest and West Suburbs", "northwest_and_west_suburbs");

        model.addAttribute("suburbsSubDistricts", suburbsSubDistricts);

        return "/chicagoDistricts/suburbs";
    }

    // 2 subsections of the suburbs
    @GetMapping("/north_suburbs")
    public String suburbNorthSuburbs(Model model) {

        String[] northSuburbsArchitecture = {
            "Shure Corporate Headquarters",
            "Levy Senior Center",
            "Jewish Reconstructionist Congregation",
            "Optima Horizons",
            "Segal Visitors Center",
            "Ryan Center for the Musical Arts",
            "Kellogg School of Management Global Hub",
            "Optima Old Orchard Woods",
            "Illinois Holocaust Museum & Education Center",
            "Lipton Thayer House",
            "Wilmette Residence",
            "Glass House & 7RR Eco-Home",
            "Crate & Barrel Headquarters",
            "Writers Theatre",
            "Daniel F. and Ada L. Rice Plant Science Conservation Center",
            "Ravinia Festival Dining Pavilion",
            "Ragdale Meadow Studio",
        };

        model.addAttribute("northSuburbsArchitecture", northSuburbsArchitecture);

        return "/chicagoDistricts/suburbsDistricts/north_suburbs";
    }

    @GetMapping("/northwest_and_west_suburbs")
    public String suburbNorthwestAndWestSuburbs() {
        return "/chicagoDistricts/suburbsDistricts/northwest_and_west_suburbs";
    }

}
