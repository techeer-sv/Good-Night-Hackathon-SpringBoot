package com.techeer.persistence.review.dto.request;


import com.techeer.persistence.restaurant.entity.Restaurant;
import com.techeer.persistence.review.entity.Review;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class ReviewReq {

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