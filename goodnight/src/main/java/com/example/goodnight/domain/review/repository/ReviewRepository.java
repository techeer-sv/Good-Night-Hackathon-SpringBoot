package com.example.goodnight.domain.review.repository;

import com.example.goodnight.domain.review.domain.Review;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ReviewRepository extends JpaRepository<Review,Long> {
    @Query("select r from Review r where r.title like %:title% or r.content like %:content%")
    Page<Review> findAllByTitleOrContent(Pageable pageable, @Param("title") String title, @Param("content") String content);
}
