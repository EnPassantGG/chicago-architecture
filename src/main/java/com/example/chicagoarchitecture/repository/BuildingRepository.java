package com.example.chicagoarchitecture.repository;

import com.example.chicagoarchitecture.model.Building;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BuildingRepository extends JpaRepository<Building, Long> {

    @Query(value = "SELECT * FROM building WHERE district = :district AND is_endorsed = false" , nativeQuery = true)
    List<Building> findByDistrict(@Param("district") String district);

    @Query("SELECT b FROM Building b WHERE b.isEndorsed = true")
    List<Building> findRecommendations();

}
