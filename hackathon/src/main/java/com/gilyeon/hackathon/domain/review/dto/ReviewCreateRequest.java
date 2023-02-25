package com.gilyeon.hackathon.domain.review.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@Builder
@AllArgsConstructor
public class ReviewCreateRequest {
    private final String title;
    private final String content;
    private final LocalDateTime createDate;
}
