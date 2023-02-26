package com.example.demo.domain.review.dao;

import com.example.demo.domain.restaurant.entity.Restaurant;
import com.example.demo.domain.review.entity.Review;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;


public interface ReviewRepository extends JpaRepository<Review, Long> {
    @Query("select r from Review r where r.id = :id and r.isActive = true")
    Optional<Review> findById(@Param("id") Long id);

}
