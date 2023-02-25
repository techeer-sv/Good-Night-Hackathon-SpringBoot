package com.example.hackathon.review.domain.repository;

import com.example.hackathon.review.domain.entity.Review;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface ReviewRepository extends JpaRepository<Review, Long> {
    @Query("select r from Review r where r.isActive is true")
    Page<Review> findReviewsWithPagination(Pageable pageable);
    @Query("select r from Review r where r.id= :id and r.isActive is true")
    Optional<Review> findReviewsById(Long id);
}
