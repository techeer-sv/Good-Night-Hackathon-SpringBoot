package com.example.goodnight.domain.review.dto.response;

import com.example.goodnight.domain.review.domain.Review;
import lombok.Builder;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Builder
public class ReviewAllResDto {
    private String restaurantName;
    private String title;
    private String content;
}
