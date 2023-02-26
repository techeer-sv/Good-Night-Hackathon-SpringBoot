package com.techeer.hackathon.domain.review.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import javax.validation.constraints.NotNull;

@Getter
@RequiredArgsConstructor
public class UpdateReviewDTO {
    @NotNull
    private String title;
    @NotNull
    private String content;
}
