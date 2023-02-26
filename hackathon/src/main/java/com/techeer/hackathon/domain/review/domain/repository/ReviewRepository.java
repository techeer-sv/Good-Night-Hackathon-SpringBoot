package com.techeer.hackathon.domain.review.domain.repository;

import com.techeer.hackathon.domain.review.domain.entity.Review;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface ReviewRepository extends JpaRepository<Review, Long> , ReviewRepositoryQuerydsl{
    @Query("select r from Review r where r.isActivated is true")
    Page<Review> findReviewWithPagination(Pageable pageable);

    @Query("select r from Review r where r.id = :ReviewId and r.isActivated = true")
    Optional<Review> findReviewById(Long id);
}
