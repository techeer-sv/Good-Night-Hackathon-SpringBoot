package com.example.hackathon.restaurant.domain.repository;

import com.example.hackathon.restaurant.domain.entity.Restaurant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface RestaurantRepository extends JpaRepository<Restaurant, Integer> {

    Optional<Restaurant> findByIdAndIsDeleted(Integer id, Boolean isDeleted);
    List<Restaurant> findAllByIsDeleted(Boolean isDeleted);
    List<Restaurant> findAllByCategoryAndIsDeleted(String category, Boolean isDeleted);

}
