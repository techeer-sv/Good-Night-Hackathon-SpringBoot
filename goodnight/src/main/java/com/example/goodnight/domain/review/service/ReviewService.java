package com.example.goodnight.domain.review.service;

import com.example.goodnight.domain.restaurant.domain.Restaurant;
import com.example.goodnight.domain.restaurant.service.RestaurantService;
import com.example.goodnight.domain.review.domain.Review;
import com.example.goodnight.domain.review.dto.request.ReviewDto;
import com.example.goodnight.domain.review.dto.response.ReviewResDto;
import com.example.goodnight.domain.review.repository.ReviewRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class ReviewService {
    private final RestaurantService restaurantService;
    private final ReviewRepository reviewRepository;

    public ReviewResDto getReview(Long id) {
        Review review = reviewRepository.findById(id).orElseThrow(null);
        Restaurant restaurant = review.getRestaurant();
        ReviewResDto dto = ReviewResDto.builder()
                .restaurantName(restaurant.getRestaurantName())
                .content(review.getContent())
                .title(review.getTitle())
                .build();
        return dto;
    }


    public void addReview(ReviewDto dto) {
        Restaurant restaurant = restaurantService.findById(dto.getRestaurantId());
        Review review = Review.builder()
                .title(dto.getTitle())
                .content(dto.getContent())
                .restaurant(restaurant)
                .build();
        reviewRepository.save(review);
    }

    public void removeReview(Long id) {
        Review review = reviewRepository.findById(id).orElseThrow(null);
        reviewRepository.delete(review);
    }
}
