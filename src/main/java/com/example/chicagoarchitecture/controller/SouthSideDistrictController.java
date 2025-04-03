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
@RequestMapping("/south_side")
public class SouthSideDistrictController {

    private final BuildingDAO buildingDAO;

    public SouthSideDistrictController(BuildingDAO buildingDAO) {
        this.buildingDAO = buildingDAO;
    }

    @GetMapping
    public String southSideDistrict(Model model) {
        LinkedHashMap<String, String> southSideSubDistricts = new LinkedHashMap<>();
        southSideSubDistricts.put("Bronzeville", "chapter_16");
        southSideSubDistricts.put("Hyde Park", "chapter_17");
        southSideSubDistricts.put("Grand Crossing & South Shore", "chapter_18");
        southSideSubDistricts.put("Other Neighborhoods", "chapter_19");
        model.addAttribute("southSideSubDistricts", southSideSubDistricts);

        return "chicagoDistricts/south_side";
    }

    @GetMapping("/{district}")
    public String southSide(Model model, @PathVariable String district) {
        List<Building> buildings = buildingDAO.getBuildingsFromDistrict(district);
        String pageTitle, pageHeader;

        switch (district) {
            case "chapter_16" -> {
                pageTitle = "Bronzeville";
                pageHeader = "South Side - Bronzeville";
            }
            case "chapter_17" -> {
                pageTitle = "Hyde Park";
                pageHeader = "South Side - Hyde Park";
            }
            case "chapter_18" -> {
                pageTitle = "Grand Crossing & South Shore";
                pageHeader = "South Side - Grand Crossing & South Shore";
            }
            case "chapter_19" -> {
                pageTitle = "Other Neighborhoods";
                pageHeader = "South Side - Other Neighborhoods";
            }
            default -> throw new IllegalArgumentException("Invalid district: " + district);
        }

        model.addAttribute("buildings", buildings);
        model.addAttribute("pageTitle", pageTitle);
        model.addAttribute("pageHeader", pageHeader);

        return "generic-page";
    }
}
