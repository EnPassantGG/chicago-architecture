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
@RequestMapping("/suburbs")
public class SuburbDistrictController {

    private final BuildingDAO buildingDAO;

    public SuburbDistrictController(BuildingDAO buildingDAO) {
        this.buildingDAO = buildingDAO;
    }

    // Main section pertaining the suburbs
    @GetMapping
    public String suburbDistrict(Model model) {
        LinkedHashMap<String, String> suburbsSubDistricts = new LinkedHashMap<>();
        suburbsSubDistricts.put("North Suburbs", "north_suburbs");
        suburbsSubDistricts.put("Northwest and West Suburbs", "northwest_and_west_suburbs");
        model.addAttribute("suburbsSubDistricts", suburbsSubDistricts);

        return "chicagoDistricts/suburbs";
    }

    @GetMapping("/{district}")
    public String downtown(Model model, @PathVariable String district) {
        List<Building> buildings = buildingDAO.getBuildingsFromDistrict(district);
        String pageTitle, pageHeader;

        switch (district) {
            case "north_suburbs" -> {
                pageTitle = "North Suburbs";
                pageHeader = "North Suburbs";
            }
            case "northwest_and_west_suburbs" -> {
                pageTitle = "Northwest and West Suburbs";
                pageHeader = "Suburbs - Northwest and West Suburbs";
            }
            default -> throw new IllegalArgumentException("Invalid district: " + district);
        }

        model.addAttribute("buildings", buildings);
        model.addAttribute("pageTitle", pageTitle);
        model.addAttribute("pageHeader", pageHeader);

        return "generic-page";
    }

}
