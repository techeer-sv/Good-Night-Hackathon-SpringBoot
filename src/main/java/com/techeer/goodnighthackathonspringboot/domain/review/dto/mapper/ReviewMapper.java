package com.techeer.goodnighthackathonspringboot.domain.review.dto.mapper;

import com.techeer.goodnighthackathonspringboot.domain.review.domain.Review;
import com.techeer.goodnighthackathonspringboot.domain.review.dto.ReviewInfo;
import com.techeer.goodnighthackathonspringboot.domain.review.dto.response.ReviewPageInfo;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

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

    public ReviewPageInfo mapEntityToReviewPageInfo(Page<Review> reviewList) {
        List<ReviewInfo> reviewInfoList =
                reviewList.stream().map(this::mapEntityToInfo).collect(Collectors.toList());
        return ReviewPageInfo.builder().reviewInfos(reviewInfoList).build();
    }
}
