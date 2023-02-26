package com.techeer.hackathon.domain.review.dto;

import lombok.Getter;
import lombok.Setter;


@Setter
@Getter
public class ReviewRequestDto {
    private String title;

    private String content;

    private Long restaurantId;
}
