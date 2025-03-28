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

        return "/chicagoDistricts/downtownDistricts/millennium_park";
    }

    @GetMapping("/lakeshore_east")
    public String downtownLakeshoreEast(Model model) {
        List<Building> buildings = buildingDAO.getBuildingsFromDistrict("lakeshore_east");
        model.addAttribute("buildings", buildings);

        return "/chicagoDistricts/downtownDistricts/lakeshore_east";
    }
}
