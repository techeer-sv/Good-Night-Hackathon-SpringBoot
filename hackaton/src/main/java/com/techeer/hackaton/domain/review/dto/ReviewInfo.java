package com.techeer.hackaton.domain.review.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
@AllArgsConstructor
public class ReviewInfo {
    private Long restaurantId;
    private String title;
    private String content;
}
