package com.techeer.goodnighthackathonspringboot.domain.review.service;

import com.techeer.goodnighthackathonspringboot.domain.restaurant.dao.RestaurantRepository;
import com.techeer.goodnighthackathonspringboot.domain.restaurant.domain.Restaurant;
import com.techeer.goodnighthackathonspringboot.domain.restaurant.exception.NotFoundRestaurantException;
import com.techeer.goodnighthackathonspringboot.domain.review.dao.ReviewRepository;
import com.techeer.goodnighthackathonspringboot.domain.review.domain.Review;
import com.techeer.goodnighthackathonspringboot.domain.review.dto.ReviewCreateRequest;
import com.techeer.goodnighthackathonspringboot.domain.review.dto.ReviewInfo;
import com.techeer.goodnighthackathonspringboot.domain.review.dto.mapper.ReviewMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ReviewService {
    private final ReviewRepository reviewRepository;
    private final RestaurantRepository restaurantRepository;
    private final ReviewMapper mapper;

    public ReviewInfo create(ReviewCreateRequest request) {
        Restaurant restaurant = restaurantRepository.findById(request.getRestaurantId())
                .orElseThrow(NotFoundRestaurantException::new);
        Review review = Review.builder()
                .restaurant(restaurant)
                .title(request.getTitle())
                .contents(request.getContents())
                .build();
        return mapper.mapEntityToInfo(reviewRepository.save(review));
    }
}
