package com.example.hackathon.review.dto;

import com.example.hackathon.review.domain.entity.Review;
import jakarta.validation.constraints.NotEmpty;
import lombok.Getter;

@Getter
public class ReviewUpdateRequest {

    @NotEmpty
    private String title;

    @NotEmpty
    private String content;

    public Review toEntity() {
        return Review.builder()
                .title(title)
                .content(content)
                .build();
    }
}
