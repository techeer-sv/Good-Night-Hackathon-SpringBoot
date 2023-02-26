package com.project.hackathon.domain.review.dto;

import com.project.hackathon.domain.restaurant.entity.Category;
import com.project.hackathon.domain.restaurant.entity.Restaurant;
import lombok.*;

import java.time.LocalDateTime;

@Setter
@Builder
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class ReviewDetailResponse {

    // 리뷰 이름
    private String title;
    // 리뷰 내용
    private String content;

    private Restaurant restaurant;
}
