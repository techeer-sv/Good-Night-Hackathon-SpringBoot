package com.techeer.hackathon.domain.review.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ReviewUpdateRequestDto {
    private String title;
    private String content;
    private Long restaurantId;
}
