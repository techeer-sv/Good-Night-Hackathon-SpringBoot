package com.techeer.hackathon.domain.review.dto;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
public class ReviewDetailResponseDto {
    private String title;
    private String restaurantName;
    private String content;

    public ReviewDetailResponseDto(String title, String restaurantName, String content) {
        this.title = title;
        this.restaurantName = restaurantName;
        this.content = content;
    }
}
