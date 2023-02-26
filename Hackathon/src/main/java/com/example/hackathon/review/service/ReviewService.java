package com.example.hackathon.review.service;

import com.example.hackathon.restaurant.domain.entity.Restaurant;
import com.example.hackathon.restaurant.domain.repository.RestaurantRepository;
import com.example.hackathon.review.ReviewMapper;
import com.example.hackathon.review.domain.entity.Review;
import com.example.hackathon.review.domain.repository.ReviewRepository;
import com.example.hackathon.review.dto.ReviewChange;
import com.example.hackathon.review.dto.ReviewCreateDTO;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
public class ReviewService {
    private final RestaurantRepository restaurantRepository;
    private final ReviewRepository reviewRepository;
    private final ReviewMapper reviewMapper;

    // https://stir.tistory.com/140 -> optional 관련
    public void createReview(ReviewCreateDTO request) {
        Restaurant restaurant = restaurantRepository.findByName(request.getRestaurantName()).orElseThrow(
                () -> new IllegalArgumentException("해당 레스토랑이 존재하지 않습니다."));
        reviewRepository.save(reviewMapper.toEntity(request, restaurant));
    } // -> 똑같은 가게이름이 2개 이상 존재할 경우 에러 발생

    public void updateReview(ReviewChange request) {
        Review findReview = reviewRepository.findById(request.getId()).orElseThrow(
                () -> new IllegalArgumentException("해당 리뷰가 존재하지 않습니다."));
        Review review = reviewMapper.toEntity(request, findReview.getRestaurant());
        reviewRepository.save(review);
    }
}
