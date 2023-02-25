package com.techeer.hackaton.domain.review.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
@AllArgsConstructor
public class ReviewCreateRequest {
    private final Long restaurantId;
    private final String title;
    private final String content;
}
