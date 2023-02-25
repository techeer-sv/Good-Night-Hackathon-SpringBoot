package com.techeer.hackathon.domain.restaurant;

import com.techeer.hackathon.domain.restaurant.dto.RestaurantCreate;
import com.techeer.hackathon.domain.restaurant.entity.Restaurant;
import org.springframework.stereotype.Component;

@Component
public class RestaurantMapper {
    public Restaurant toEntity(RestaurantCreate request) {
        return Restaurant.builder()
                        .category(request.getCategory())
                        .name(request.getName())
                        .build();
    }
}
