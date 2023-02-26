package com.example.demo.domain.review.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.demo.domain.review.entity.Review;

@Repository
public interface ReviewRepository extends JpaRepository<Review, Long> {

    @Query(value = "SELECT * FROM review ORDER BY id DESC LIMIT :page, :size", nativeQuery = true)
    List<Review> findAllOrderByCreatedAtDesc(@Param("page") int page, @Param("size") int size);

    @Query(value = "SELECT * FROM review WHERE title LIKE %:searchKeyword% OR content LIKE %:searchKeyword% ORDER BY id DESC LIMIT :page, :size", nativeQuery = true)
    List<Review> findAllContainingTitleAndContentOrderByCreatedAtDesc(@Param("searchKeyword") String searchKeyword, @Param("page") int page, @Param("size") int size);

    @Query(value = "SELECT * FROM review WHERE title LIKE %:searchKeyword% ORDER BY id DESC LIMIT :page, :size", nativeQuery = true)
    List<Review> findAllContainingTitleOrderByCreatedAtDesc(@Param("searchKeyword") String searchKeyword, @Param("page") int page, @Param("size") int size);

    @Query(value = "SELECT * FROM review WHERE content LIKE %:searchKeyword% ORDER BY id DESC LIMIT :page, :size", nativeQuery = true)
    List<Review> findAllContainingContentOrderByCreatedAtDesc(@Param("searchKeyword") String searchKeyword, @Param("page") int page, @Param("size") int size);
}