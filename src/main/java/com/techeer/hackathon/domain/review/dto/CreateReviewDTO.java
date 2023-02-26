package com.techeer.hackathon.domain.review.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import javax.validation.constraints.NotNull;

@Getter
@RequiredArgsConstructor
public class CreateReviewDTO {
    @NotNull
    private Long restaurantId;
    @NotNull
    private String title;
    private String content;
}
