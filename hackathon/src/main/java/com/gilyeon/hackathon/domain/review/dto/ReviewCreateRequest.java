package com.gilyeon.hackathon.domain.review.dto;

import com.gilyeon.hackathon.domain.restaurant.entity.Restaurant;
import com.gilyeon.hackathon.domain.review.entity.Review;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class ReviewCreateRequest {
    private String title;
    private String content;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private long restaurantId;

    public Review toEntity(Restaurant restaurant) {
        return Review.builder()
                .title(title)
                .content(content)
                .restaurant(restaurant)
                .build();
    }

}
