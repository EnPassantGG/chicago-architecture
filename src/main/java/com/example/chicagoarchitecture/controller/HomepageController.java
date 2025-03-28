package com.example.chicagoarchitecture.controller;

import com.example.chicagoarchitecture.model.Building;
import com.example.chicagoarchitecture.service.BuildingDAO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.LinkedHashMap;
import java.util.List;

@Controller
public class HomepageController {

    private final BuildingDAO buildingDAO;

    public HomepageController(BuildingDAO buildingDAO) {
        this.buildingDAO = buildingDAO;
    }

    @GetMapping("/")
    public String homePage(Model model) {
        // Used for drop-down searching
        List<String> cities = buildingDAO.getDistinctCities();
        for (String city : cities) System.out.println(city);
        model.addAttribute("cities", cities);

        // List of Chicago districts with respective webpages
        LinkedHashMap<String, String> chicagoDistricts = new LinkedHashMap<>();
        chicagoDistricts.put("Downtown", "downtown");
        chicagoDistricts.put("North Side (coming soon)", "north_side");
        chicagoDistricts.put("West Side (coming soon)", "west_side");
        chicagoDistricts.put("South Side (coming soon)", "south_side");
        chicagoDistricts.put("Suburbs", "suburbs");
        model.addAttribute("chicagoDistricts", chicagoDistricts);

        return "homepage";
    }


    @GetMapping("/north_side")
    public String northSideDistrict() {
        return "/chicagoDistricts/north_side";
    }

    @GetMapping("/west_side")
    public String westSideDistrict() {
        return "/chicagoDistricts/west_side";
    }

    @GetMapping("/south_side")
    public String southSideDistrict() {
        return "/chicagoDistricts/south_side";
    }


//    @GetMapping("/search")
//    public String searchForm(Model model) {
//        List<String> cities = buildingDAO.getDistinctCities();
//        for (String city : cities) System.out.println(city);
//        model.addAttribute("cities", cities);
//
//        return "search";
//    }

    @PostMapping("/search")
    public String searchResult(@RequestParam("city") String city, Model model) {
        List<Building> results = buildingDAO.getBuildingsByCity(city);
        model.addAttribute("results", results);

        return "result";
    }

    @GetMapping("/about")
    public String aboutPage() {
        return "about";
    }

    @GetMapping("/personal_recommendations")
    public String personalFindingsPage(Model model) {
        List<Building> buildings = buildingDAO.getRecommendations();
        model.addAttribute("buildings", buildings);

        return "personal_recommendations";
    }

}
