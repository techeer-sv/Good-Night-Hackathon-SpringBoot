package com.example.goodnight.domain.restaurant.dto.response;

import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@Builder
public class RestaurantResDto {
    private String restaurantName;
    private String category;
    private LocalDateTime createdAt;
}
