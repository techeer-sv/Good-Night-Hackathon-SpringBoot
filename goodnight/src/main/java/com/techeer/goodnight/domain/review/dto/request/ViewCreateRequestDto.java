package com.techeer.goodnight.domain.review.dto.request;

import com.techeer.goodnight.domain.restaurant.entity.Restaurant;
import com.techeer.goodnight.domain.review.entity.Review;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class ViewCreateRequestDto {

    private long restaurantId;

    private String title;

    private String description;

    public Review toEntity(Restaurant restaurant) {
        return Review.builder()
                .title(title)
                .description(description)
                .restaurant(restaurant)
                .build();
    }

}