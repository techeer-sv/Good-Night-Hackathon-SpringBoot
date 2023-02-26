package com.example.demo.domain.review.map;

import com.example.demo.domain.restaurant.entity.Restaurant;
import com.example.demo.domain.review.dto.request.ReviewCreateRequest;
import com.example.demo.domain.review.dto.request.ReviewUpdateRequest;
import com.example.demo.domain.review.entity.Review;
import org.springframework.stereotype.Component;

@Component
public class ToEntity {

    public Review toCreateEntity(ReviewCreateRequest review, Restaurant restaurant) {
        return Review.builder()
                .title(review.getTitle())
                .content(review.getContent())
                .restaurant(restaurant)
                .build();
    }

    public Review toUpdateEntity(ReviewUpdateRequest review) {
        return Review.builder()
                .title(review.getTitle())
                .content(review.getContent())
                .build();
    }
}
