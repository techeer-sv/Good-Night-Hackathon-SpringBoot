package com.example.demo.domain.restaurant.repository;

import com.example.demo.domain.restaurant.entity.Restaurant;
import com.example.demo.global.enumpkg.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface RestaurantRepository extends JpaRepository<Restaurant, Long> {

    Restaurant findByIdAndIsDeletedFalse(Long id);

    List<Restaurant> findAllByIsDeletedFalse();

    List<Restaurant> findAllByCategoryAndIsDeletedFalse(Category category);

    @Transactional
    @Modifying(clearAutomatically = true)
    @Query("UPDATE Restaurant r SET r.isDeleted = true WHERE r.id = :id")
    void deleteByIdAndIsDeletedFalse(Long id);

}