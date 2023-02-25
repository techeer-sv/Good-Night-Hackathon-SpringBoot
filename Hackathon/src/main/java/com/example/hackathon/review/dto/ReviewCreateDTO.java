package com.example.hackathon.review.dto;

import com.example.hackathon.restaurant.domain.entity.Restaurant;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class ReviewCreateDTO {
    private Restaurant restaurant;
    private String title;
    private String content;
}
