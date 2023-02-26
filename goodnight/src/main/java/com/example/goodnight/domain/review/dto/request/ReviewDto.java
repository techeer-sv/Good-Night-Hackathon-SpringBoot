package com.example.goodnight.domain.review.dto.request;

import lombok.Getter;

@Getter
public class ReviewDto {
    private String title;
    private String content;
    private Long restaurantId;
}
