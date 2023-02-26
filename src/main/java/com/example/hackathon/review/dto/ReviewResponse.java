package com.example.hackathon.review.dto;

import com.example.hackathon.review.domain.entity.Review;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Builder
@Data
public class ReviewResponse {

    private Integer reviewId;

    private String restaurantName;

    private String title;

    private String content;

    private LocalDateTime createdAt;

    public static ReviewResponse of(
            Review entity
    ) {
        return ReviewResponse.builder()
                .reviewId(entity.getId())
                .restaurantName(entity.getRestaurant().getName())
                .title(entity.getTitle())
                .content(entity.getContent())
                .createdAt(entity.getCreatedAt())
                .build();
    }
}
