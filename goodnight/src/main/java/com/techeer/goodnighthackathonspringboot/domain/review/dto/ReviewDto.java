package com.techeer.goodnighthackathonspringboot.domain.review.dto;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class ReviewDto {
    private String storeName;
    private String reviewName;
    private String reviewContent;
    
}
