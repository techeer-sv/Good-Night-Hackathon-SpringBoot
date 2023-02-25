package com.techeer.goodnight.domain.review.service;

import com.techeer.goodnight.domain.restaurant.service.RestaurantService;
import com.techeer.goodnight.domain.restaurant.entity.Restaurant;
import com.techeer.goodnight.domain.review.repository.ReviewRepository;

import com.techeer.goodnight.domain.review.dto.request.ViewCreateRequestDto;
import com.techeer.goodnight.domain.review.dto.request.ViewUpdateRequestDto;
import com.techeer.goodnight.domain.review.dto.response.ReviewResponseDto;
import com.techeer.goodnight.domain.review.entity.Review;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;


@Service
@RequiredArgsConstructor
public class ReviewService {

    private final ReviewRepository reviewRepository;
    private final RestaurantService restaurantService;


    public ReviewResponseDto create(ViewCreateRequestDto reviewReq) {
        Restaurant restaurant = restaurantService.findByIdInner(reviewReq.getRestaurantId());

        Review review = reviewReq.toEntity(restaurant);

        reviewRepository.save(review);

        return new ReviewResponseDto(review, restaurant);
    }

    @Transactional(readOnly = true)
    public Page<ReviewResponseDto> findAll(Pageable pageable, Optional<String> keyword) {
        Page<Review> reviews = reviewRepository.findAllWithKeyword(pageable, keyword);

        return reviews.map(review -> new ReviewResponseDto(review, review.getRestaurant()));
    }

    public ReviewResponseDto findById(long id) {
        Review review = reviewRepository.findById(id).orElseThrow();

        return new ReviewResponseDto(review, review.getRestaurant());
    }


    public ReviewResponseDto patchById(long id, ViewUpdateRequestDto patchReviewReq) {
        Review review = reviewRepository.findById(id).orElseThrow();

        review.setTitle(patchReviewReq.getTitle());
        review.setDescription(patchReviewReq.getDescription());

        reviewRepository.save(review);

        return new ReviewResponseDto(review, review.getRestaurant());
    }

    public void deleteById(long id) {
        reviewRepository.deleteById(id);
    }
}