package com.gilyeon.hackathon.domain.review;

import com.gilyeon.hackathon.domain.review.entity.Review;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Arrays;
import java.util.Optional;

@Repository
public interface ReviewRepository extends JpaRepository<Review, Long> {
    @Query("SELECT r FROM Review r WHERE r.id = :id AND r.isDeleted = false")
    Optional<Review> findById(@Param("id") Long id);

    @Query("SELECT r FROM Review r WHERE r.isDeleted is false")
    Page<Review> findReviewWithPagination(Pageable pageable);

    @Query("SELECT r FROM Review r WHERE r.isDeleted is false AND (r.title LIKE %:keyword% OR r.content LIKE %:keyword%)")
    Page<Review> findReviewContainTitleOrContentWithPagination(
            Pageable pageable, @Param("keyword") String keyword);
}