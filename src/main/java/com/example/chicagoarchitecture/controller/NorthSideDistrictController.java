package com.example.chicagoarchitecture.controller;

import com.example.chicagoarchitecture.service.BuildingDAO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.LinkedHashMap;

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
}
