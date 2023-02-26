package com.techeer.hackathon.domain.review.repository;

import com.techeer.hackathon.domain.restaurant.entity.Restaurant;
import com.techeer.hackathon.domain.review.entity.Review;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ReviewRepository extends JpaRepository<Review, Long> {

    @Query(value = "SELECT r\n " +
            "FROM Review r\n " +
            "WHERE (r.title = '' OR r.title Like CONCAT('%', :title, '%'))\n " +
            "AND (r.content = '' OR r.content Like CONCAT('%', :content, '%'))\n")
    Page<Review> findAllBySearch(String title, String content, Pageable pageable);

//    @Query( "SELECT r FROM Review r WHERE r.title LIKE %:title% OR r.content LIKE %:content%" )
//    Page<Review> findAllBySearch(String title, String content, Pageable pageable);
}
