package com.example.hackathon.review.dto;

import lombok.*;

@Getter
@Builder
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class ReviewCreateDTO {
    private String restaurantName;
    private String title;
    private String content;
}
