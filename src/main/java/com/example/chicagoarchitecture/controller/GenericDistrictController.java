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
import java.util.Map;

@Controller
@RequestMapping("/region")
public class GenericDistrictController {

    private final BuildingDAO buildingDAO;

    public GenericDistrictController(BuildingDAO buildingDAO) {
        this.buildingDAO = buildingDAO;
    }

    private static final Map<String, LinkedHashMap<String, String>> DISTRICT_SUBDISTRICTS = Map.of(
            "downtown", new LinkedHashMap<>() {{
                put("Millennium Park", "millennium_park");
                put("Lakeshore East", "lakeshore_east");
                put("The Loop (East)", "the_loop_east");
                put("The Loop (West)", "the_loop_west");
                put("South Loop & Chinatown", "south_loop_and_chinatown");
            }},
            "north_side", new LinkedHashMap<>() {{
                put("River North", "river_north");
                put("Streeterville", "streeterville");
                put("Near North Side", "near_north_side");
                put("Lincoln Park", "lincoln_park");
                put("Lakeview & North Center", "lakeview_and_north_center");
                put("Other neighborhoods", "other_neighborhoods");
            }},
            "west_side", new LinkedHashMap<>() {{
                put("General West Side", "first_chapter");
                put("Bucktown, Wicker Park, & West town", "second_chapter");
                put("West Loop", "third_chapter");
                put("University Village, Lawndale, & Pilsen", "fourth_chapter");
            }},
            "south_side", new LinkedHashMap<>() {{
                put("Bronzeville", "chapter_16");
                put("Hyde Park", "chapter_17");
                put("Grand Crossing & South Shore", "chapter_18");
                put("Other Neighborhoods", "chapter_19");
            }},
            "suburbs", new LinkedHashMap<>() {{
                put("North Suburbs", "north_suburbs");
                put("Northwest and West Suburbs", "northwest_and_west_suburbs");
            }}
    );

    private static final Map<String, String> DISTRICT_TITLES = new LinkedHashMap<>();
    static {
        DISTRICT_TITLES.put("millennium_park", "Millennium Park");
        DISTRICT_TITLES.put("lakeshore_east", "Lakeshore East");
        DISTRICT_TITLES.put("the_loop_east", "The Loop (East)");
        DISTRICT_TITLES.put("the_loop_west", "The Loop (West)");
        DISTRICT_TITLES.put("south_loop_and_chinatown", "South Loop & Chinatown");

        DISTRICT_TITLES.put("river_north", "River North");
        DISTRICT_TITLES.put("streeterville", "Streeterville");
        DISTRICT_TITLES.put("near_north_side", "Near North Side");
        DISTRICT_TITLES.put("lincoln_park", "Lincoln Park");
        DISTRICT_TITLES.put("lakeview_and_north_center", "Lakeview & North Center");
        DISTRICT_TITLES.put("other_neighborhoods", "Other Neighborhoods");

        DISTRICT_TITLES.put("first_chapter", "General West Side");
        DISTRICT_TITLES.put("second_chapter", "Bucktown, Wicker Park, & West town");
        DISTRICT_TITLES.put("third_chapter", "West Loop");
        DISTRICT_TITLES.put("fourth_chapter", "University Village, Lawndale, & Pilsen");

        DISTRICT_TITLES.put("chapter_16", "Bronzeville");
        DISTRICT_TITLES.put("chapter_17", "Hyde Park");
        DISTRICT_TITLES.put("chapter_18", "Grand Crossing & South Shore");
        DISTRICT_TITLES.put("chapter_19", "Other Neighborhoods");

        DISTRICT_TITLES.put("north_suburbs", "North Suburbs");
        DISTRICT_TITLES.put("northwest_and_west_suburbs", "Northwest and West Suburbs");
    }

    @GetMapping("/{region}")
    public String showRegion(@PathVariable String region, Model model) {
        LinkedHashMap<String, String> subDistricts = DISTRICT_SUBDISTRICTS.get(region);

        model.addAttribute("subDistricts", subDistricts);
        model.addAttribute("region", region);

        return "generic-region-page";
    }

    @GetMapping("/{region}/{district}")
    public String showDistrict(@PathVariable String region, @PathVariable String district, Model model) {
        List<Building> buildings = buildingDAO.getBuildingsFromDistrict(district);
        String pageTitle = DISTRICT_TITLES.get(district);

        model.addAttribute("buildings", buildings);
        model.addAttribute("pageTitle", pageTitle);
        model.addAttribute("pageHeader", pageTitle);

        return "generic-page";
    }
}
