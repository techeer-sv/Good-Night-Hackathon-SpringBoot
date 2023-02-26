package com.techeer.goodnighthackathonspringboot.domain.review.dao;

import com.techeer.goodnighthackathonspringboot.domain.review.domain.Review;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ReviewRepository extends JpaRepository<Review, Long> {
    @Query("select r from Review r where r.isActivated is true order by r.createOn asc")
    Page<Review> findReviewWithPaginationOrderByCreatedOnAsc(Pageable pageable);

    @Query("select r from Review r where r.isActivated is true order by r.createOn desc")
    Page<Review> findReviewWithPaginationOrderByCreatedOnDesc(Pageable pageable);

}
