package com.techeer.goodnighthackathonspringboot.domain.restaurant.dao;

import com.techeer.goodnighthackathonspringboot.domain.restaurant.domain.Restaurant;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RestaurantRepository extends JpaRepository<Restaurant, Long> {
}
