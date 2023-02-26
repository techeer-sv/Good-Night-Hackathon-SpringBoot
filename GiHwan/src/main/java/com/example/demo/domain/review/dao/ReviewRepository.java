package com.example.demo.domain.review.dao;

import com.example.demo.domain.review.entity.Review;

import org.springframework.data.jpa.repository.JpaRepository;


public interface ReviewRepository extends JpaRepository<Review, Long> {

}
