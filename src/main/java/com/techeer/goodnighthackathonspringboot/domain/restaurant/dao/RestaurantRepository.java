package com.techeer.goodnighthackathonspringboot.domain.restaurant.dao;

import com.techeer.goodnighthackathonspringboot.domain.restaurant.domain.Restaurant;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface RestaurantRepository extends JpaRepository<Restaurant, Long> {

    @Query("select r from Restaurant r where r.isActivated is true")
    Page<Restaurant> findRestaurantWithPagination(Pageable pageable);
}
