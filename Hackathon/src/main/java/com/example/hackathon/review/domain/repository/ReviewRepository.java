package com.example.hackathon.review.domain.repository;

import com.example.hackathon.review.domain.entity.Review;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;


public interface ReviewRepository extends JpaRepository<Review, Long> {

    Optional<Review> findById(Long id);

    // 리뷰 수정
    @Modifying // insert, update , delete 등 db에 변화가 발생하는 작업에는 필수
    @Transactional // 이 과정 중 다른 연산이 끼어들 수 없게 하는 어노테이션
    @Query("update Review v set v.title = :title ,v.content = :content where v.id = :id")
    void updateReview(@Param("id") Long id , @Param("title") String title, @Param("content") String content);
}
