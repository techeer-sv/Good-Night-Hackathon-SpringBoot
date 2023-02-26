package com.example.demo.domain.review.dto;

import com.example.demo.domain.restaurant.entity.Restaurant;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;


import java.time.LocalDateTime;

@Getter
@Builder
@AllArgsConstructor
public class ReviewCreateResponse {
    private final LocalDateTime createdAt;

    private final String title;

    private final String content;

    private final Long restaurantId;
}
