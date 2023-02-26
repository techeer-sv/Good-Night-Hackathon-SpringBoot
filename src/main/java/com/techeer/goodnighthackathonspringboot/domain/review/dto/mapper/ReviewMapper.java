package com.techeer.goodnighthackathonspringboot.domain.review.dto.mapper;

import com.techeer.goodnighthackathonspringboot.domain.review.domain.Review;
import com.techeer.goodnighthackathonspringboot.domain.review.dto.ReviewInfo;
import org.springframework.stereotype.Component;

@Component
public class ReviewMapper {

    public ReviewInfo mapEntityToInfo(Review review){
        return ReviewInfo.builder()
                .id(review.getId())
                .restaurantId(review.getRestaurant().getId())
                .title(review.getTitle())
                .contents(review.getContents())
                .build();
    }
}
