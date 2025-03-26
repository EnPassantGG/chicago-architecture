package com.example.chicagoarchitecture.controller;

import com.example.chicagoarchitecture.model.Building;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

@Controller
@RequestMapping("/suburbs")
public class SuburbDistrictController {

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

        String[] northSuburbsArchitecture = {
            "Shure Corporate Headquarters",
            "Levy Senior Center",
            "Jewish Reconstructionist Congregation",
            "Optima Horizons",
            "Segal Visitors Center",
            "Ryan Center for the Musical Arts",
            "Kellogg School of Management Global Hub",
            "Optima Old Orchard Woods",
            "Illinois Holocaust Museum & Education Center",
            "Lipton Thayer House",
            "Wilmette Residence",
            "Glass House & 7RR Eco-Home",
            "Crate & Barrel Headquarters",
            "Writers Theatre",
            "Daniel F. and Ada L. Rice Plant Science Conservation Center",
            "Ravinia Festival Dining Pavilion",
            "Ragdale Meadow Studio",
        };

        Building n177 = new Building("Shure Corporate Headquarters", "5800 West Touhy Avenue",
                "Niles", 2004);
        Building n178 = new Building("Levy Senior Center", "300 Dodge Avenue",
                "Evanston", 2002);
        Building n179 = new Building("Jewish Reconstructionist Congregation", "303 Dodge Avenue",
                "Evanston", 2008);
        Building n180 = new Building("Optima Horizons", "800 Elgin Road",
                "Evanston", 2004);
        Building n181 = new Building("Segal Visitors Center", "1841 Sheridan Road",
                "Evanston", 2014);
        Building n182 = new Building("Ryan Center for the Musical Arts", "70 Arts Circle Drive",
                "Evanston", 2015);
        Building n183 = new Building("Kellogg School of Management Global Hub", "2211 Campus Drive",
                "Evanston", 2017);
        Building n184 = new Building("Optima Old Orchard Woods", "9739 Woods Drive",
                "Skokie", 2008);
        Building n185 = new Building("Illinois Holocaust Museum & Education Center", "9603 Woods Drive",
                "Skokie", 2009);
        Building n186 = new Building("Lipton Thayer House", "2600 Thayer Street",
                "Evanston", 2018);
        Building n187 = new Building("Wilmette Residence", "1019 Linden Avenue",
                "Wilmette", 2016);
        Building n188 = new Building("Glass House & 7RR Eco-Home", "Rolling Ridge Lane",
                "Northfield", 2012);
        Building n189 = new Building("Crate & Barrel Headquarters", "1250 Techny Road",
                "Northbrook", 2002);
        Building n190 = new Building("Writers Theatre", "325 Tudor Court",
                "Glencoe", 2016);
        Building n191 = new Building("Daniel F. and Ada L. Rice Plant Science Conservation Center", "1000 Lake Cook Road",
                "Glencoe", 2009);
        Building n192 = new Building("Ravinia Festival Dining Pavilion", "418 Sheridan Road",
                "Glencoe", 2007);
        Building n193 = new Building("Ragdale Meadow Studio", "1260 Green Bay Road",
                "Lake Forest", 2008);

        List<Building> buildings = new ArrayList<>();
        buildings.add(n177);
        buildings.add(n178);
        buildings.add(n179);
        buildings.add(n180);
        buildings.add(n181);
        buildings.add(n182);
        buildings.add(n183);
        buildings.add(n184);
        buildings.add(n185);
        buildings.add(n186);
        buildings.add(n187);
        buildings.add(n188);
        buildings.add(n189);
        buildings.add(n190);
        buildings.add(n191);
        buildings.add(n192);
        buildings.add(n193);


        model.addAttribute("northSuburbsArchitecture", northSuburbsArchitecture);
        model.addAttribute("buildings", buildings);

        return "/chicagoDistricts/suburbsDistricts/north_suburbs";
    }

    @GetMapping("/northwest_and_west_suburbs")
    public String suburbNorthwestAndWestSuburbs() {
        return "/chicagoDistricts/suburbsDistricts/northwest_and_west_suburbs";
    }

}
