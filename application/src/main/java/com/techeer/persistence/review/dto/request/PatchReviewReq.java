package com.techeer.persistence.review.dto.request;


import com.techeer.persistence.restaurant.entity.Restaurant;
import com.techeer.persistence.review.entity.Review;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class PatchReviewReq {

    private String title;

    private String description;

}