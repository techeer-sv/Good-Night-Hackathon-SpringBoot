package com.techeer.hackathon.domain.restaurant.repository;

import com.techeer.hackathon.domain.restaurant.entity.Restaurant;
import com.techeer.hackathon.domain.restaurant.entity.RestaurantCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface RestaurantRepository extends JpaRepository<Restaurant, Long> {
    boolean existsByName(String name);

    @Modifying
    @Transactional
    @Query("update Restaurant r set r.category = :category where r.id = :id")
    void updateCategory(@Param("id") Long id, @Param("category") RestaurantCategory category);

    @Query("SELECT r FROM Restaurant r WHERE r.category IN :categories")
    List<Restaurant> findByCategory(@Param("categories") List<RestaurantCategory> categories);

    @Modifying
    @Transactional
    @Query("update Restaurant r set r.isDeleted = 1 where r.id = :id")
    void softDeleteById(Long id);
}
