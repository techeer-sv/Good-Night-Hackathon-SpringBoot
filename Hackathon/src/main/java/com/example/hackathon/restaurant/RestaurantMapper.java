package com.example.hackathon.restaurant;

import com.example.hackathon.restaurant.domain.entity.Restaurant;
import com.example.hackathon.restaurant.dto.RestaurantCreateDTO;
import org.springframework.stereotype.Component;

@Component
public class RestaurantMapper {
    public Restaurant toEntity (RestaurantCreateDTO request) {
        return Restaurant.builder()
                .category(request.getCategory())
                .name(request.getName())
                .build();
    }
}
