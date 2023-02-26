package com.example.demo.domain.review.service;

import com.example.demo.domain.restaurant.dao.RestaurantRepository;
import com.example.demo.domain.review.dao.ReviewRepository;
import com.example.demo.domain.review.dto.ReviewCreateResponse;
import com.example.demo.domain.review.entity.Review;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class ReviewService {
    private final ReviewRepository reviewRepository;
    private final RestaurantRepository restaurantRepository;

    @Transactional
    public ReviewCreateResponse createReview(ReviewCreateResponse reviewCreateResponse){
        Review review = mapReviewEntityReviewCreateResponseToReview(reviewCreateResponse);
        reviewRepository.save(review);
        return reviewCreateResponse;
    }

    public Review mapReviewEntityReviewCreateResponseToReview(ReviewCreateResponse reviewCreateResponse){
        return Review.builder()
                .title(reviewCreateResponse.getTitle())
                .content(reviewCreateResponse.getContent())
                .restaurant(reviewCreateResponse.getRestaurant())
                .build();
    }
}
