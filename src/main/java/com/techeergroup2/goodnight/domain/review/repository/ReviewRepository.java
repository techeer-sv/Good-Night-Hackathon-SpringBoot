package com.techeergroup2.goodnight.domain.review.repository;


import com.techeergroup2.goodnight.domain.review.domain.Review;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReviewRepository extends JpaRepository<Review, Long> {
}
