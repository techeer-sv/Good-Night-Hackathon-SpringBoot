package com.techeer.hackathon.domain.review.repository;

import com.techeer.hackathon.domain.review.entity.Review;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface RepositoryReview extends JpaRepository<Review, Long> {
    Optional<Review> findByIdAndDeletedFalse(Long id);

    @Query(value = "SELECT r\n " +
            "FROM Review r\n " +
            "WHERE (r.title = '' OR r.title Like CONCAT('%', :title, '%'))\n " +
            "AND (r.content = '' OR r.content Like CONCAT('%', :content, '%'))\n")
    Page<Review> findAllBySearch(String title, String content, Pageable pageable);

    List<Review> findAllByOrderByCreatedAtAsc();
    List<Review> findAllByOrderByCreatedAtDesc();
}
