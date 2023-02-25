package com.techeer.hackathon.domain.review.repository;

import com.techeer.hackathon.domain.review.entity.Review;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReviewRepository extends JpaRepository<Review, Long> {
//    @Query("select l from Location l where l.post.id = :id and l.isActive = true")
}
