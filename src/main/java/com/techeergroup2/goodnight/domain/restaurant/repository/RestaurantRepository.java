package com.techeergroup2.goodnight.domain.restaurant.repository;

import com.techeergroup2.goodnight.domain.restaurant.domain.Restaurant;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface RestaurantRepository extends JpaRepository<Restaurant, Long> {
    Optional<Restaurant> findByName(String name);
    List<Restaurant> findAllByCategory(String category);
}
