package com.techeer.hackaton.domain.restaurant.repository;

import com.techeer.hackaton.domain.restaurant.entity.Restaurant;
import com.techeer.hackaton.domain.restaurant.entity.RestaurantCategory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface RestaurantRepository extends JpaRepository<Restaurant, Long> {
//    @Query("select l from Location l where l.post.id = :id and l.isActive = true")
    @Query("select r from Restaurant r where r.id = :id and r.isActive = true")
    Optional<Restaurant> findById(@Param("id") Long id);

    @Query("select r from Restaurant r where r.isActive is true")
    Page<Restaurant> findRestaurantsWithPagination(Pageable pageable);

    @Query("select r from Restaurant r where r.category = :category and r.isActive is true")
    Page<Restaurant> findRestaurantsByCategoryWithPagination(Pageable pageable, RestaurantCategory category);
}
