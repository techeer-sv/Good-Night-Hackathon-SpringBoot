package com.example.demo.domain.review.map;

import com.example.demo.domain.review.dto.response.ReviewResponse;
import com.example.demo.domain.review.entity.Review;
import org.springframework.stereotype.Component;

@Component
public class ToResponse {
    public ReviewResponse toResponse(Review review) {
        return ReviewResponse.builder()
                .id(review.getId())
                .restaurantName(review.getRestaurant().getName())
                .title(review.getTitle())
                .content(review.getContent())
                .createdAt(review.getCreatedAt())
                .build();
    }
}
