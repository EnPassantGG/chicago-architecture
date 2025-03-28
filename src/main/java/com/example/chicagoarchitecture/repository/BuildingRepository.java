package com.example.chicagoarchitecture.repository;

import com.example.chicagoarchitecture.model.Building;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BuildingRepository extends JpaRepository<Building, Long> {

    // Native SQL query
    @Query(value = "SELECT * FROM building WHERE district = :district AND is_endorsed = false" , nativeQuery = true)
    List<Building> findByDistrict(@Param("district") String district);

    // Java Persistence Query Language (JPQL)
    @Query("SELECT b FROM Building b WHERE b.isEndorsed = true")
    List<Building> findRecommendations();

    @Query(value = "SELECT DISTINCT city FROM building ORDER BY city", nativeQuery = true)
    List<String> findDistinctCities();

    @Query(value = "SELECT * FROM building WHERE city = :city", nativeQuery = true)
    List<Building> findByCity(@Param("city") String city);

}
