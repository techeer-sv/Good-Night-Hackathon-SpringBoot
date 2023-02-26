package com.techeergroup2.goodnight.domain.review.service;

import com.techeergroup2.goodnight.domain.restaurant.domain.Restaurant;
import com.techeergroup2.goodnight.domain.restaurant.repository.RestaurantRepository;
import com.techeergroup2.goodnight.domain.review.domain.Review;
import com.techeergroup2.goodnight.domain.review.dto.ReviewCreateRequest;
import com.techeergroup2.goodnight.domain.review.dto.ReviewCreateResponse;
import com.techeergroup2.goodnight.domain.review.repository.ReviewRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.List;
import java.util.Optional;

@Transactional
@AllArgsConstructor
@Service
public class ReviewService {

    private final ReviewRepository reviewRepository;

    private final RestaurantRepository restaurantRepository;

    public ReviewCreateResponse createReview(Long id, ReviewCreateRequest request) {
        Restaurant restaurant = restaurantRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("No restaurant is found. id=" + id));
        Review review = Review.builder()
                .title(request.getTitle())
                .content(request.getContent())
                .restaurant(restaurant)
                .build();

        reviewRepository.save(review);
        return review.toResponse();
    }

    public ReviewCreateResponse getReview(Long id) {
        return reviewRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("No review is found. id=" + id)).toResponse();
    }

    public ReviewCreateResponse updateReview(Long id, ReviewCreateRequest request) {
        Review review = reviewRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("No review is found. id=" + id));
        review.updateTitle(request.getTitle());
        review.updateContent(request.getContent());
        reviewRepository.save(review);
        return review.toResponse();
    }

    public void deleteReview(Long id) {
        reviewRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("No review is found. id=" + id));
        reviewRepository.deleteById(id);
    }

    public List<Review> getAllReviews(Pageable pageable, Optional<String> title, Optional<String> content) {
        if (title.isPresent() || content.isPresent()) {
            return reviewRepository.findAllSearch(title.orElse("-"), content.orElse("-"), pageable);
        }
        return reviewRepository.findAll(pageable).getContent();
    }
}
