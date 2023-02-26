package com.techeer.hackathon.domain.review.dto;

import com.techeer.hackathon.domain.restaurant.entity.Restaurant;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Builder
@Getter
@AllArgsConstructor
public class ReviewResponseDto {
    private Long id;
    private String restaurantName;
    private String title;
    private String content;
}