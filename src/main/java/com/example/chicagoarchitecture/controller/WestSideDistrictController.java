package com.example.chicagoarchitecture.controller;

import com.example.chicagoarchitecture.model.Building;
import com.example.chicagoarchitecture.service.BuildingDAO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.LinkedHashMap;
import java.util.List;

@Controller
@RequestMapping("/west_side")
public class WestSideDistrictController {

    private final BuildingDAO buildingDAO;

    public WestSideDistrictController(BuildingDAO buildingDAO) {
        this.buildingDAO = buildingDAO;
    }

    @GetMapping
    public String southSideDistrict(Model model) {
        LinkedHashMap<String, String> westSideSubDistricts = new LinkedHashMap<>();
        westSideSubDistricts.put("General West Side", "first_chapter");
        westSideSubDistricts.put("Bucktown, Wicker Park, & West town", "second_chapter");
        westSideSubDistricts.put("West Loop", "third_chapter");
        westSideSubDistricts.put("University Village, Lawndale, & Pilsen", "fourth_chapter");
        model.addAttribute("westSideSubDistricts", westSideSubDistricts);

        return "chicagoDistricts/west_side";
    }

    @GetMapping("/{district}")
    public String westSide(Model model, @PathVariable String district) {
        List<Building> buildings = buildingDAO.getBuildingsFromDistrict(district);
        String pageTitle, pageHeader;

        switch (district) {
            case "first_chapter" -> {
                pageTitle = "General West Side";
                pageHeader = "West Side - General West Side";
            }
            case "second_chapter" -> {
                pageTitle = "Bucktown, Wicker Park, & West town";
                pageHeader = "West Side - Bucktown, Wicker Park, & West town";
            }
            case "third_chapter" -> {
                pageTitle = "West Loop";
                pageHeader = "West Side - West Loop";
            }
            case "fourth_chapter" -> {
                pageTitle = "University Village, Lawndale, & Pilsen";
                pageHeader = "West Side - University Village, Lawndale, & Pilsen";
            }
            default -> throw new IllegalArgumentException("Invalid district: " + district);
        }

        model.addAttribute("buildings", buildings);
        model.addAttribute("pageTitle", pageTitle);
        model.addAttribute("pageHeader", pageHeader);

        return "generic-page";
    }
}
