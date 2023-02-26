package com.example.goodnight.domain.review.service;

import com.example.goodnight.domain.restaurant.domain.Restaurant;
import com.example.goodnight.domain.restaurant.service.RestaurantService;
import com.example.goodnight.domain.review.domain.Review;
import com.example.goodnight.domain.review.dto.request.ReviewDto;
import com.example.goodnight.domain.review.dto.request.ReviewReqDto;
import com.example.goodnight.domain.review.dto.response.ReviewAllResDto;
import com.example.goodnight.domain.review.dto.response.ReviewResDto;
import com.example.goodnight.domain.review.repository.ReviewRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

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

    public List<ReviewAllResDto> getReviews(String title, String content) {
        return reviewRepository.findAllByTitleOrContent(title, content).stream().map(this::mapReviewEntityToReviewAllResDto).collect(Collectors.toList());
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

    public void updateReview(Long id, String title, String content) {
        Review review = reviewRepository.findById(id).orElseThrow(null);
        review.update(title,content);
    }

    public ReviewAllResDto mapReviewEntityToReviewAllResDto(Review review) {
        return ReviewAllResDto.builder()
                .restaurantName(review.getRestaurant().getRestaurantName())
                .title(review.getTitle())
                .content(review.getContent())
                .build();
    }
}
