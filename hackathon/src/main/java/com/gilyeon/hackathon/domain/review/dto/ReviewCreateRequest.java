package com.gilyeon.hackathon.domain.review.dto;

import com.gilyeon.hackathon.domain.restaurant.entity.Restaurant;
import com.gilyeon.hackathon.domain.review.entity.Review;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@AllArgsConstructor
public class ReviewCreateRequest {
    private final String title;
    private final String content;
    private final LocalDateTime createdAt;
    private final LocalDateTime updatedAt;
    private final long restaurantId;

}
