package com.project.hackathon.domain.restaurant.repository;

import com.project.hackathon.domain.restaurant.entity.Category;
import com.project.hackathon.domain.restaurant.entity.Restaurant;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import java.util.List;
import java.util.Optional;

public interface RestaurantRepository extends JpaRepository<Restaurant, Long> {

    @Query("select r from Restaurant r where r.id = :id and r.isActive = true")
    Optional<Restaurant> findRestaurantById(@Param("id") Long id);
    List<Restaurant> findAll();

    @Query("select r from Restaurant r where r.category = :category and r.isActive is true")
    List<Restaurant> findByCategory(Category category);

    @Query("select r from Restaurant r where r.isActive is true")
    Page<Restaurant> findRestaurantWithPagination(Pageable pageable);

    @Query("select r from Restaurant r where r.isActive is true and r.title like %:keyword%")
    Page<Restaurant> findContainingTitleRestaurantWithPagination(
            Pageable pageable, @Param("keyword") String keyword);
}