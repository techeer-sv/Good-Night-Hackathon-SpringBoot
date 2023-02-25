package com.example.hackathon.review;

import com.example.hackathon.review.domain.entity.Review;
import com.example.hackathon.review.dto.ReviewCreateDTO;
import org.springframework.stereotype.Component;

@Component
public class ReviewMapper {
    public Review toEntity (ReviewCreateDTO request) {
        return Review.builder()
                .restaurant(request.getRestaurant())
                .title(request.getTitle())
                .content(request.getContent())
                .build();
    }
}
