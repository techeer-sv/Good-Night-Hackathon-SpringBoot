package com.techeer.goodnight.domain.review.dto.request;

import com.techeer.goodnight.domain.restaurant.entity.Restaurant;
import com.techeer.goodnight.domain.review.entity.Review;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class ViewUpdateRequestDto {

    private String title;

    private String description;

}