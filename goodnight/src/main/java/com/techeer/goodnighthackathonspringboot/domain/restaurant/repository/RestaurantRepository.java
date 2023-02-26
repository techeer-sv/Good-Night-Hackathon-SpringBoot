package com.techeer.goodnighthackathonspringboot.domain.restaurant.repository;


import com.techeer.goodnighthackathonspringboot.domain.restaurant.entity.Restaurant;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RestaurantRepository extends JpaRepository<Restaurant, Long> {
}
