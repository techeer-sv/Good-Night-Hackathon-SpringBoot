package com.techeer.goodnight.domain.review.dto.response;

import com.techeer.goodnight.domain.restaurant.entity.Restaurant;
import com.techeer.goodnight.domain.review.entity.Review;

import java.time.LocalDateTime;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class ReviewResponseDto {

    private long id;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;

    private String restaurantName;

    private String title;
    private String description;

    @Builder
    public ReviewResponseDto(Review review, Restaurant restaurant) {
        this.id = review.getId();
        this.createdAt = review.getCreatedAt();
        this.updatedAt = review.getUpdatedAt();
        this.restaurantName = restaurant.getName();
        this.title = review.getTitle();
        this.description = review.getDescription();
    }
}