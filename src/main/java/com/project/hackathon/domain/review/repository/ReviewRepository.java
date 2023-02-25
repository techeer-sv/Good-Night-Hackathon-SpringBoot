package com.project.hackathon.domain.review.repository;

import com.project.hackathon.domain.restaurant.entity.Restaurant;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface ReviewRepository extends JpaRepository<Restaurant, Long> {

    @Query("select p from Review p where p.id = :id")
    Optional<Restaurant> findReviewById(@Param("id") Long id);

    @Query("select u from Review u where u.title = :title")
    Optional<Restaurant> findReviewByTitle(@Param("title") String title);

    @Query("select u from Review u where u.content = :content")
    Optional<Restaurant> findReviewByContent(@Param("content") String content);

    @Query("select p from Review p")
    Page<Restaurant> findReviewWithPagination(Pageable pageable);

    @Query("select p from Review p where p.title like %:keyword%")
    Page<Restaurant> findContainingTitleReviewWithPagination(
            Pageable pageable, @Param("keyword") String keyword);
}