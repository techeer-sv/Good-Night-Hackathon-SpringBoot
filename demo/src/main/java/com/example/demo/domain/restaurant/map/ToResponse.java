package com.example.demo.domain.restaurant.map;

import com.example.demo.domain.restaurant.dto.response.RestaurantResponse;
import com.example.demo.domain.restaurant.entity.Restaurant;
import org.springframework.stereotype.Component;

@Component
public class ToResponse {
    public RestaurantResponse toResponse(Restaurant restaurant) {
        return RestaurantResponse.builder()
                .id(restaurant.getId())
                .name(restaurant.getName())
                .category(restaurant.getCategory())
                .createdAt(restaurant.getCreatedAt())
                .build();
    }
}
