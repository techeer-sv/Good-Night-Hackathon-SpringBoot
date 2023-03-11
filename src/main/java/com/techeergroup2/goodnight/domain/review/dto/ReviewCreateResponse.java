package com.techeergroup2.goodnight.domain.review.dto;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class ReviewCreateResponse {
    private String title;
    private String content;

}
