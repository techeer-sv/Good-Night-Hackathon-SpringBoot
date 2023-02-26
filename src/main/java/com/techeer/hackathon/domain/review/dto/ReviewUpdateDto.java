package com.techeer.hackathon.domain.review.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import javax.validation.constraints.NotNull;

@Getter
@RequiredArgsConstructor
public class ReviewUpdateDto {
    @NotNull
    private Long id;

    @NotNull
    private String title;

    @NotNull
    private String content;
}
