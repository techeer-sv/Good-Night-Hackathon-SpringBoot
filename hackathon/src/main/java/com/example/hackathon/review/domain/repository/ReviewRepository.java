package com.example.hackathon.review.domain.repository;

import com.example.hackathon.review.domain.entity.Review;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReviewRepository extends JpaRepository<Review, Integer>{

    @Query(value = "SELECT r\n " +
            "FROM Review r\n " +
            "WHERE (r.title = '' OR r.title Like CONCAT('%', :title, '%'))\n " +
            "AND (r.content = '' OR r.content Like CONCAT('%', :content, '%'))\n")
    List<Review> findAllWithFieldQuery(
            String title,
            String content,
            Pageable pageable
    );
}
