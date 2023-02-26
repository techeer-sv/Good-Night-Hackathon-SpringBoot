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

    @Query("select r from Review r where r.title like :title and r.isActive = true")
    Optional<Review> findReviewByTitle(@Param("title") String title);

    @Query("select r from Review r where r.content like :content and r.isActive = true")
    Optional<Review> findReviewByContent(@Param("content") String content);

    @Query("select r from Review r where r.isActive = true")
    Page<Review> findReviewWithPagination(Pageable pageable);

    @Query("select r from Review r where r.isActive = true and r.title like %:keyword%")
    Page<Review> findContainingTitleReviewWithPagination(
            Pageable pageable, @Param("keyword") String keyword);
}