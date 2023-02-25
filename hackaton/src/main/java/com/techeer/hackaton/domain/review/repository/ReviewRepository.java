package com.techeer.hackaton.domain.review.repository;

import com.techeer.hackaton.domain.restaurant.entity.Restaurant;
import com.techeer.hackaton.domain.review.entity.Review;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface ReviewRepository extends JpaRepository<Review, Long> {
    @Query("select r from Review r where r.id = :id and r.isActive = true")
    Optional<Review> findById(@Param("id") Long id);

    @Query("select r from Review r where r.isActive is true")
    Page<Review> findReviewWithPagination(Pageable pageable);

    @Query("select r from Review r where r.isActive is true and r.title like %:keyword%")
    Page<Review> findContainingTitlePostWithPagination(
            Pageable pageable, @Param("keyword") String keyword);

    @Query("select r from Review r where r.isActive is true and r.content like %:keyword%")
    Page<Review> findContainingContentPostWithPagination(
            Pageable pageable, @Param("keyword") String keyword);
}
