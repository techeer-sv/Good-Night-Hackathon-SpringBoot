package com.techeer.goodnight.domain.review.repository;
import com.techeer.goodnight.domain.review.entity.Review;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.Optional;

public interface ReviewRepository extends PagingAndSortingRepository<Review, Long>, JpaRepository<Review, Long> {

    @Query("select r from Review r where r.title LIKE %:keyword or r.description LIKE %:keyword and r.isDeleted is false")
    Page<Review> findAllWithKeyword(Pageable pageable, Optional<String> keyword);
}