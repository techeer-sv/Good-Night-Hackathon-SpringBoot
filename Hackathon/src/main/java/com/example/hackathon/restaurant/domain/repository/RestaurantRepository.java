package com.example.hackathon.restaurant.domain.repository;

import com.example.hackathon.restaurant.domain.entity.Restaurant;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RestaurantRepository extends JpaRepository<Restaurant, Long> {
    boolean existsByName(String name);
}
