package com.techeergroup2.goodnight.domain.restaurant.repository;

import com.techeergroup2.goodnight.domain.restaurant.domain.Restaurant;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RestaurantRepository extends JpaRepository<Restaurant, Long> {

}
