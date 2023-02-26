package com.techeer.hackathon.domain.review.dto;

import lombok.*;

@Getter
@Builder
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class ReviewInfo {
    private String restaurantName;
    private String title;
    private String content;
}
