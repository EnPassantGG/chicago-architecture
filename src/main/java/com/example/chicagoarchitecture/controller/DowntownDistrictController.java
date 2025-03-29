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

    @GetMapping("/millennium_park")
    public String downtownMillenniumPark(Model model) {
        List<Building> buildings = buildingDAO.getBuildingsFromDistrict("millennium_park");
        model.addAttribute("buildings", buildings);
        model.addAttribute("pageTitle", "Millennium Park");
        model.addAttribute("pageHeader", "Downtown - Millennium Park");

        return "generic-page";
    }

    @GetMapping("/lakeshore_east")
    public String downtownLakeshoreEast(Model model) {
        List<Building> buildings = buildingDAO.getBuildingsFromDistrict("lakeshore_east");
        model.addAttribute("buildings", buildings);
        model.addAttribute("pageTitle", "Lakeshore East");
        model.addAttribute("pageHeader", "Downtown - Lakeshore East");

        return "generic-page";
    }

    @GetMapping("/the_loop_east")
    public String downtownTheLoopEast(Model model) {
        List<Building> buildings = buildingDAO.getBuildingsFromDistrict("the_loop_east");
        model.addAttribute("buildings", buildings);
        model.addAttribute("pageTitle", "The Loop East");
        model.addAttribute("pageHeader", "Downtown - The Loop East");

        return "generic-page";
    }

    @GetMapping("/the_loop_west")
    public String downtownTheLoopWest(Model model) {
        List<Building> buildings = buildingDAO.getBuildingsFromDistrict("the_loop_west");
        model.addAttribute("buildings", buildings);
        model.addAttribute("pageTitle", "The Loop West");
        model.addAttribute("pageHeader", "Downtown - The Loop West");

        return "generic-page";
    }

    @GetMapping("/south_loop_and_chinatown")
    public String downtownSouthLoopAndChinatown(Model model) {
        List<Building> buildings = buildingDAO.getBuildingsFromDistrict("south_loop_and_chinatown");
        model.addAttribute("pageTitle", "South Loop and Chinatown");
        model.addAttribute("pageHeader", "Downtown - South Loop and Chinatown");

        return "generic-page";
    }
}
