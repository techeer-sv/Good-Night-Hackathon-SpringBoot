package com.project.hackathon.domain.restaurant.repository;

import com.project.hackathon.domain.restaurant.entity.Restaurant;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface RestaurantRepository extends JpaRepository<Restaurant, Long> {

    @Query("select p from Restaurant p where p.id = :id")
    Optional<Restaurant> findRestaurantById(@Param("id") Long id);

    @Query("select u from Restaurant u where u.restaurantCategory = :restaurantCategory")
    Optional<Restaurant> findRestaurantByCategory(@Param("restaurantCategory") String restaurantCategory);

    @Query("select p from Restaurant p")
    Page<Restaurant> findRestaurantWithPagination(Pageable pageable);

    @Query("select p from Restaurant p where p.title like %:keyword%")
    Page<Restaurant> findContainingTitleRestaurantWithPagination(
            Pageable pageable, @Param("keyword") String keyword);
}