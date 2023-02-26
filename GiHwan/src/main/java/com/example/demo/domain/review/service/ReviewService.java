package com.example.demo.domain.review.service;

import com.example.demo.domain.restaurant.dao.RestaurantRepository;
import com.example.demo.domain.restaurant.entity.Restaurant;
import com.example.demo.domain.review.dao.ReviewRepository;
import com.example.demo.domain.review.dto.ReviewCreateResponse;
import com.example.demo.domain.review.dto.ReviewInfo;
import com.example.demo.domain.review.dto.ReviewUpdateRequest;
import com.example.demo.domain.review.entity.Review;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;

@RequiredArgsConstructor
@Service
public class ReviewService {
    private final ReviewRepository reviewRepository;
    private final RestaurantRepository restaurantRepository;

    @Transactional
    public ReviewCreateResponse createReview(ReviewCreateResponse reviewCreateResponse){
        Restaurant restaurant = restaurantRepository.findById(reviewCreateResponse.getRestaurantId())
                .orElseThrow(EntityNotFoundException::new);
        Review review = mapReviewEntityReviewCreateResponseToReview(reviewCreateResponse,restaurant);
        reviewRepository.save(review);
        return reviewCreateResponse;
    }

    @Transactional(readOnly = true)
    public ReviewInfo getReviewDetail(Long id){
        Review review = reviewRepository.findById(id)
                .orElseThrow(EntityNotFoundException::new);
        return mapReviewEntityToReviewInfo(review);
    }

    @Transactional
    public ReviewInfo updateReview(ReviewUpdateRequest reviewUpdateRequest){
        Review review = reviewRepository.findById(reviewUpdateRequest.getId())
                .orElseThrow(EntityNotFoundException::new);
        review.update(reviewUpdateRequest);
        reviewRepository.save(review);
        return mapReviewEntityToReviewInfo(review);
    }


    public ReviewInfo mapReviewEntityToReviewInfo(Review review){
        return ReviewInfo.builder()
                .title(review.getTitle())
                .content(review.getContent())
                .restaurantName(review.getRestaurant().getName())
                .build();
    }
    public Review mapReviewEntityReviewCreateResponseToReview(ReviewCreateResponse reviewCreateResponse, Restaurant restaurant){
        return Review.builder()
                .title(reviewCreateResponse.getTitle())
                .content(reviewCreateResponse.getContent())
                .restaurant(restaurant)
                .build();
    }
}
