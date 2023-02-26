package com.techeer.hackathon.domain.review.repository;

import com.techeer.hackathon.domain.review.entity.Review;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.swing.*;
import java.util.Optional;

public interface RepositoryReview extends JpaRepository<Review, Long> {
    Optional<Review> findByIdAndDeletedFalse(Long id);
}
