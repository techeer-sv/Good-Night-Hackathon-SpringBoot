package com.techeer.hackaton.domain.restaurant.repository;

import com.techeer.hackaton.domain.restaurant.entity.Restaurant;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RestaurantRepository extends JpaRepository<Restaurant, Long> {
//    @Query("select l from Location l where l.post.id = :id and l.isActive = true")
}
