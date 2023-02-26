package com.project.hackathon.domain.review.repository;

import com.project.hackathon.domain.restaurant.entity.Restaurant;
import com.project.hackathon.domain.review.entity.Review;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface ReviewRepository extends JpaRepository<Review, Long> {

    @Query("select r from Review r where r.id = :id and r.isActive = true")
    Optional<Review> findReviewById(@Param("id") Long id);
    List<Review> findAll();

    @Query("select r from Review r where r.isActive = true and (r.title like %:keyword% or r.content like %:keyword%)")
    Page<Review> findContainingTitleOrContentReviewWithPagination(
            Pageable pageable, @Param("keyword") String keyword);
}