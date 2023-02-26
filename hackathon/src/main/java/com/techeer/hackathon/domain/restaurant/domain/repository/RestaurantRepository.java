package com.techeer.hackathon.domain.restaurant.domain.repository;

import com.techeer.hackathon.domain.restaurant.domain.entity.Restaurant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface RestaurantRepository extends JpaRepository<Restaurant, Long> {
    @Query("select r from Restaurant r where r.id = :restaurantId and r.isDeleted = true")
    Optional<Restaurant> findByRestaurantId(Long restaurantId);
}
