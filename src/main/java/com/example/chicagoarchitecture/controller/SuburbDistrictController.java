package com.example.chicagoarchitecture.controller;

import com.example.chicagoarchitecture.model.Building;
import com.example.chicagoarchitecture.service.BuildingDAO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
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

        return "/chicagoDistricts/suburbs";
    }

    // 2 subsections of the suburbs
    @GetMapping("/north_suburbs")
    public String suburbNorthSuburbs(Model model) {
        List<Building> buildings = buildingDAO.getBuildingsFromDistrict("north_suburbs");
        model.addAttribute("buildings", buildings);

        return "/chicagoDistricts/suburbsDistricts/north_suburbs";
    }

    @GetMapping("/northwest_and_west_suburbs")
    public String suburbNorthwestAndWestSuburbs(Model model) {
        List<Building> buildings = buildingDAO.getBuildingsFromDistrict("northwest_and_west_suburbs");
        model.addAttribute("buildings", buildings);

        return "/chicagoDistricts/suburbsDistricts/northwest_and_west_suburbs";
    }

}
