package com.example.chicagoarchitecture.service;

import com.example.chicagoarchitecture.model.Building;
import com.example.chicagoarchitecture.repository.BuildingRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BuildingDAO {

    private final BuildingRepository buildingRepository;

    public BuildingDAO(BuildingRepository buildingRepository) {
        this.buildingRepository = buildingRepository;
    }

    public List<Building> getBuildingsFromDistrict(String district) {
        return buildingRepository.findByDistrict(district);
    }

    public List<Building> getRecommendations() {
        return buildingRepository.findRecommendations();
    }

    public List<String> getDistinctCities() {
        return buildingRepository.findDistinctCities();
    }

    public List<Building> getBuildingsByCity(String city) {
        return buildingRepository.findByCity(city);
    }
}
