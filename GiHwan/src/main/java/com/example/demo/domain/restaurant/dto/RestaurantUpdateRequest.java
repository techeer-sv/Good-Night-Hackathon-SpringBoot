package com.example.demo.domain.restaurant.dto;

import com.example.demo.domain.restaurant.entity.RestaurantCategory;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
@AllArgsConstructor
public class RestaurantUpdateRequest {
    private final Long id;
    private final RestaurantCategory category;
}
