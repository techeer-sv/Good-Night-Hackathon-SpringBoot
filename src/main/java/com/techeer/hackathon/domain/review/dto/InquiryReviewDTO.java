package com.techeer.hackathon.domain.review.dto;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class InquiryReviewDTO {
    private Long id;
    private String restaurantName;
    private String title;
    private String content;

}