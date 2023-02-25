package com.techeer.hackaton.domain.review.service;

import com.techeer.hackaton.domain.restaurant.dto.RestaurantInfo;
import com.techeer.hackaton.domain.restaurant.entity.Restaurant;
import com.techeer.hackaton.domain.restaurant.repository.RestaurantRepository;
import com.techeer.hackaton.domain.review.dto.ReviewCreateRequest;
import com.techeer.hackaton.domain.review.dto.ReviewInfo;
import com.techeer.hackaton.domain.review.dto.ReviewUpdateRequest;
import com.techeer.hackaton.domain.review.entity.Review;
import com.techeer.hackaton.domain.review.repository.ReviewRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;

@RequiredArgsConstructor
@Service
@Slf4j
public class ReviewService {
    private final ReviewRepository reviewRepository;
    private final RestaurantRepository restaurantRepository;

    @Transactional
    public void createReview(ReviewCreateRequest reviewCreateRequest) {
        Restaurant foundRestaurant = restaurantRepository.findById(reviewCreateRequest.getRestaurantId())
                .orElseThrow(EntityNotFoundException::new);

        Review foundReview = mapReviewCreateRequestToReviewEntity(reviewCreateRequest, foundRestaurant);
        reviewRepository.save(foundReview);
    }

    @Transactional(readOnly = true)
    public ReviewInfo getReviewDetail(Long id) {
        Review foundReview = reviewRepository.findById(id)
                .orElseThrow(EntityNotFoundException::new);

        return mapReviewEntityToReviewInfo(foundReview);
    }

    @Transactional
    public ReviewInfo updateReview(ReviewUpdateRequest reviewUpdateRequest) {
        Review foundReview = reviewRepository.findById(reviewUpdateRequest.getId())
                .orElseThrow(EntityNotFoundException::new);

        foundReview.update(reviewUpdateRequest);

        Review savedReview = reviewRepository.save(foundReview);

        return mapReviewEntityToReviewInfo(savedReview);
    }

    public Review mapReviewCreateRequestToReviewEntity(ReviewCreateRequest reviewCreateRequest, Restaurant restaurant) {
        return Review.builder()
                .title(reviewCreateRequest.getTitle())
                .content(reviewCreateRequest.getContent())
                .restaurant(restaurant)
                .build();
    }

    public ReviewInfo mapReviewEntityToReviewInfo(Review review) {
        return ReviewInfo.builder()
                .title(review.getTitle())
                .content(review.getContent())
                .restaurantName(review.getRestaurant().getName())
                .build();
    }
}
