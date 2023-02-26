package com.example.demo.domain.restaurant.map;

import com.example.demo.domain.restaurant.dto.request.RestaurantCreateRequest;
import com.example.demo.domain.restaurant.entity.Restaurant;
import org.springframework.stereotype.Component;

@Component
public class ToRestaurantEntity {

    public Restaurant toCreateEntity(RestaurantCreateRequest restaurant) {
        return Restaurant.builder()
                .name(restaurant.getName())
                .category(restaurant.getCategory())
                .build();
    }

}
