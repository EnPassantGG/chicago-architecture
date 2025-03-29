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
@RequestMapping("/downtown")
public class DowntownDistrictController {

    private final BuildingDAO buildingDAO;

    public DowntownDistrictController(BuildingDAO buildingDAO) {
        this.buildingDAO = buildingDAO;
    }

    @GetMapping
    public String downtownDistrict(Model model) {
        LinkedHashMap<String, String> downtownSubDistricts = new LinkedHashMap<>();
        downtownSubDistricts.put("Millennium Park", "millennium_park");
        downtownSubDistricts.put("Lakeshore East", "lakeshore_east");
        downtownSubDistricts.put("The Loop (East)", "the_loop_east");
        downtownSubDistricts.put("The Loop (West)", "the_loop_west");
        downtownSubDistricts.put("South Loop & Chinatown", "south_loop_and_chinatown");
        model.addAttribute("downtownSubDistricts", downtownSubDistricts);

        return "/chicagoDistricts/downtown";
    }

    @GetMapping("/{district}")
    public String downtown(Model model, @PathVariable String district) {
        List<Building> buildings = buildingDAO.getBuildingsFromDistrict(district);
        String pageTitle, pageHeader;

        switch (district) {
            case "millennium_park" -> {
                pageTitle = "Millennium Park";
                pageHeader = "Downtown - Millennium Park";
            }
            case "lakeshore_east" -> {
                pageTitle = "Lakeshore East";
                pageHeader = "Downtown - Lakeshore East";
            }
            case "the_loop_east" -> {
                pageTitle = "The Loop East";
                pageHeader = "Downtown - The Loop East";
            }
            case "the_loop_west" -> {
                pageTitle = "The Loop West";
                pageHeader = "Downtown - The Loop West";
            }
            case "south_loop_and_chinatown" -> {
                pageTitle = "South Loop and Chinatown";
                pageHeader = "Downtown - South Loop and Chinatown";
            }
            default -> throw new IllegalArgumentException("Invalid district: " + district);
        }

        model.addAttribute("buildings", buildings);
        model.addAttribute("pageTitle", pageTitle);
        model.addAttribute("pageHeader", pageHeader);

        return "generic-page";
    }

}
