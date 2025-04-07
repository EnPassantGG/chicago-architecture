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

    static class DistrictData {
        String title;
        String path;

        DistrictData(String title, String path) {
            this.title = title;
            this.path = path;
        }
    }

    private static final Map<String, List<DistrictData>> DISTRICT_SUBDISTRICTS = Map.of(
            "downtown", List.of(
                    new DistrictData("Millennium Park", "millennium_park"),
                    new DistrictData("Lakeshore East", "lakeshore_east"),
                    new DistrictData("The Loop (East)", "the_loop_east"),
                    new DistrictData("The Loop (West)", "the_loop_west"),
                    new DistrictData("South Loop & Chinatown", "south_loop_and_chinatown")
            ),
            "north_side", List.of(
                    new DistrictData("River North", "river_north"),
                    new DistrictData("Streeterville", "streeterville"),
                    new DistrictData("Near North Side", "near_north_side"),
                    new DistrictData("Lincoln Park", "lincoln_park"),
                    new DistrictData("Lakeview & North Center", "lakeview_and_north_center"),
                    new DistrictData("Other neighborhoods", "other_neighborhoods")
            ),
            "west_side", List.of(
                    new DistrictData("General West Side", "first_chapter"),
                    new DistrictData("Bucktown, Wicker Park, & West town", "second_chapter"),
                    new DistrictData("West Loop", "third_chapter"),
                    new DistrictData("University Village, Lawndale, & Pilsen", "fourth_chapter")
            ),
            "south_side", List.of(
                    new DistrictData("Bronzeville", "chapter_16"),
                    new DistrictData("Hyde Park", "chapter_17"),
                    new DistrictData("Grand Crossing & South Shore", "chapter_18"),
                    new DistrictData("Other Neighborhoods", "chapter_19")
            ),
            "suburbs", List.of(
                    new DistrictData("North Suburbs", "north_suburbs"),
                    new DistrictData("Northwest and West Suburbs", "northwest_and_west_suburbs")
            )
    );

    private static final Map<String, String> DISTRICT_TITLES = new LinkedHashMap<>();

    static {
        for (List<DistrictData> districtList : DISTRICT_SUBDISTRICTS.values()) {
            for (DistrictData districtData : districtList) {
                DISTRICT_TITLES.put(districtData.path, districtData.title);
            }
        }
    }

    @GetMapping("/{region}")
    public String showRegion(@PathVariable String region, Model model) {
        List<DistrictData> subDistrictsList = DISTRICT_SUBDISTRICTS.get(region);
        Map<String, String> subDistricts = new LinkedHashMap<>();

        if (subDistrictsList != null) {
            for (DistrictData districtData : subDistrictsList) {
                subDistricts.put(districtData.title, districtData.path);
            }
        }

        model.addAttribute("subDistricts", subDistricts);
        model.addAttribute("region", toTitleCase(region));

        return "generic-region-page";
    }

    @GetMapping("/{region}/{district}")
    public String showDistrict(@PathVariable String region, @PathVariable String district, Model model) {
        List<Building> buildings = buildingDAO.getBuildingsFromDistrict(district);
        String pageTitle = DISTRICT_TITLES.get(district);

        model.addAttribute("buildings", buildings);
        model.addAttribute("pageTitle", pageTitle);
        model.addAttribute("pageHeader", pageTitle);

        return "generic-district-page";
    }

    private String toTitleCase(String input) {
        String[] words = input.split("_");
        StringBuilder sb = new StringBuilder();
        for (String word : words) {
            if (!word.isEmpty()) {
                sb.append(Character.toUpperCase(word.charAt(0))); // first char to upper
                sb.append(word.substring(1));           // add rest of word to sb
                sb.append(" ");                                   // add a space
            }
        }
        return sb.toString().trim();
    }
}
