package com.techeer.hackathon.domain.restaurant.repository;

import com.techeer.hackathon.domain.restaurant.entity.Restaurant;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import org.springframework.data.domain.Pageable;
import java.util.List;

@Repository
public interface RestaurantRepository extends JpaRepository<Restaurant, Long> {

    @Query("select r from Restaurant r where r.activated is true")
    Page<Restaurant> findRestaurants(Pageable pageable);
    @Query("select r from Restaurant r where r.activated is true and r.category = :category")
    Page<Restaurant> findByCategory(@Param("category")String category, Pageable pageable);
}