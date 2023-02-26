package com.techeergroup2.goodnight.domain.review.repository;


import com.techeergroup2.goodnight.domain.review.domain.Review;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.net.ContentHandler;
import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface ReviewRepository extends JpaRepository<Review, Long> {

    @Query(value = "SELECT r FROM Review r WHERE r.title LIKE %:title% OR r.content LIKE %:content%")
    List<Review> findAllSearch(String title, String content, Pageable pageable);


}
