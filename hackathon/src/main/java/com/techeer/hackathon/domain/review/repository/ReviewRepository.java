package com.techeer.hackathon.domain.review.repository;

import com.techeer.hackathon.domain.review.entity.Review;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

public interface ReviewRepository extends JpaRepository<Review, Long> {

    @Modifying
    @Transactional
    @Query("update Review r set r.content = '' where r.id = :id")
    void softDeleteById(Long id);

//    @Modifying
//    @Transactional
//    @Query("update Review r set r.content = '' where r.id = :id")
//    void update(Review review);
}
