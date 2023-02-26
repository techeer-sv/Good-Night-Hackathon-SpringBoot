package com.techeer.hackathon.domain.review.repository;

import com.techeer.hackathon.domain.review.entity.Review;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.swing.*;

public interface RepositoryReview extends JpaRepository<Review, Long> {
}
