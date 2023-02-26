package com.example.demo.domain.review.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
@AllArgsConstructor
public class ReviewUpdateRequest {

    private final Long id;
    private final String title;

    private final String content;

}
