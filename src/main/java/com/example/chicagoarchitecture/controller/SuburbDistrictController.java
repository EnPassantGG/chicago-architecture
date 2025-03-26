package com.example.chicagoarchitecture.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.LinkedHashMap;

@Controller
public class SuburbDistrictController {

    // Main section pertaining the suburbs
    @GetMapping("/suburbs")
    public String suburbDistrict(Model model) {

        LinkedHashMap<String, String> suburbsSubDistricts = new LinkedHashMap<>();
        suburbsSubDistricts.put("North Suburbs", "north_suburbs");
        suburbsSubDistricts.put("Northwest and West Suburbs", "northwest_and_west_suburbs");

        for (String keyValue : suburbsSubDistricts.keySet()) {
            System.out.println("Key: " + keyValue);
            System.out.println("Value: " + suburbsSubDistricts.get(keyValue));
        }

        model.addAttribute("suburbsSubDistricts", suburbsSubDistricts);

        return "/chicagoDistricts/suburbs";
    }

    // 2 subsections of the suburbs
    @GetMapping("/suburbs/north_suburbs")
    public String suburbNorthSuburbs() {
        return "/chicagoDistricts/suburbsSubDistricts/north_suburbs";
    }

    @GetMapping("/suburbs/northwest_and_west_suburbs")
    public String suburbNorthwestAndWestSuburbs() {
        return "/chicagoDistricts/suburbsSubDistricts/northwest_and_west_suburbs";
    }

}
