package com.example.hackathon.review.dto;

import com.example.hackathon.restaurant.domain.entity.Restaurant;
import com.example.hackathon.review.domain.entity.Review;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class ReviewRequest {

    @NotNull
    private Integer restaurantId;

    @NotEmpty
    private String title;

    @NotEmpty
    private String content;

    public Review toEntity(Restaurant restaurant) {
        return Review.builder()
                .restaurant(restaurant)
                .title(title)
                .content(content)
                .build();
    }
}
