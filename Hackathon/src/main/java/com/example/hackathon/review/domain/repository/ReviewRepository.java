package com.example.hackathon.review.domain.repository;

import com.example.hackathon.review.domain.entity.Review;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface ReviewRepository extends JpaRepository<Review, Integer> {
    @Query()
    Page<Review> findReviewsWithPagination(Pageable pageable);

    @Query("select r from Review r where r.id= :id and r.isActivated is true")
    Optional<Review> findReviewsById(int id);
}
