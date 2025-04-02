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
@RequestMapping("/north_side")
public class NorthSideDistrictController {

    private final BuildingDAO buildingDAO;

    public NorthSideDistrictController(BuildingDAO buildingDAO) {
        this.buildingDAO = buildingDAO;
    }

    @GetMapping
    public String northSideDistrict(Model model) {
        LinkedHashMap<String, String> northSideSubDistricts = new LinkedHashMap<>();
        northSideSubDistricts.put("River North", "river_north");
        northSideSubDistricts.put("Streeterville", "streeterville");
        northSideSubDistricts.put("Near North Side", "near_north_side");
        northSideSubDistricts.put("Lincoln Park", "lincoln_park");
        northSideSubDistricts.put("Lakeview & North Center", "lakeview_and_north_center");
        northSideSubDistricts.put("Other neighborhoods", "other_neighborhoods");
        model.addAttribute("northSideSubDistricts", northSideSubDistricts);

        return "chicagoDistricts/north_side";
    }

    @GetMapping("/{district}")
    public String northSide(Model model, @PathVariable String district) {
        List<Building> buildings = buildingDAO.getBuildingsFromDistrict(district);
        String pageTitle, pageHeader;

        switch (district) {
            case "river_north" -> {
                pageTitle = "River North";
                pageHeader = "North Side - Millennium Park";
            }
            case "streeterville" -> {
                pageTitle = "Streeterville";
                pageHeader = "North Side - Streeterville";
            }
            case "near_north_side" -> {
                pageTitle = "Near North Side";
                pageHeader = "North Side - Near North Side";
            }
            case "lincoln_park" -> {
                pageTitle = "Lincoln Park";
                pageHeader = "North Side - Lincoln Park";
            }
            case "lakeview_and_north_center" -> {
                pageTitle = "Lakeview & North Center";
                pageHeader = "North Side - Lakeview & North Center";
            }
            case "other_neighborhoods" -> {
                pageTitle = "Other Neighborhoods";
                pageHeader = "North Side - Other Neighborhoods";
            }
            default -> throw new IllegalArgumentException("Invalid district: " + district);
        }

        model.addAttribute("buildings", buildings);
        model.addAttribute("pageTitle", pageTitle);
        model.addAttribute("pageHeader", pageHeader);

        return "generic-page";
    }
}
