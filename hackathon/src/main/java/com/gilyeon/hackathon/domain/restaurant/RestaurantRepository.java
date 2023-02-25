package com.gilyeon.hackathon.domain.restaurant;

import com.gilyeon.hackathon.domain.restaurant.entity.Restaurant;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RestaurantRepository extends JpaRepository<Restaurant, String> {
    List<Restaurant> findByRestaurantId (Long id);

}

