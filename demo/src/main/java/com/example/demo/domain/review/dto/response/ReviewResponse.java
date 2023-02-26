package com.example.demo.domain.review.dto.response;

import com.example.demo.domain.restaurant.dto.response.RestaurantResponse;
import com.example.demo.domain.restaurant.entity.Restaurant;
import com.example.demo.domain.review.entity.Review;
import com.example.demo.global.enumpkg.Category;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ReviewResponse {
    private Long id;
    private String restaurantName;
    private String title;

    private String content;

    private LocalDateTime createdAt;

}
