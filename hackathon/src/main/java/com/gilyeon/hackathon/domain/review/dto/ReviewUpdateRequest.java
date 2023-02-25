package com.gilyeon.hackathon.domain.review.dto;

import com.gilyeon.hackathon.domain.restaurant.entity.RestaurantCategory;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
@AllArgsConstructor
public class ReviewUpdateRequest {
    // review update는 id와 content 사용. - content 변경가능
    private final Long id;
    private final String content;
}