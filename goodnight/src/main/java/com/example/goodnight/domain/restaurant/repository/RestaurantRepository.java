package com.example.goodnight.domain.restaurant.repository;

import com.example.goodnight.domain.restaurant.domain.Restaurant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface RestaurantRepository extends JpaRepository<Restaurant, Long> {
    @Query(value = "select r from Restaurant r where r.category = :category and r.isActivated = true")
    List<Restaurant> findAllByCategory(@Param("category") String category);

    @Query(value = "select r from Restaurant r where r.isActivated = true")
    List<Restaurant> findAll();

    @Query(value = "select r from Restaurant r where r.id = :id and r.isActivated = true")
    Optional<Restaurant> findById(@Param("id") Long id);
}