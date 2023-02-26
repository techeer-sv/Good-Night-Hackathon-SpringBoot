package com.techeer.hackathon.domain.restaurant.mapper;

import com.techeer.hackathon.domain.restaurant.dto.RestaurantCreate;
import com.techeer.hackathon.domain.restaurant.dto.RestaurantResponse;
import com.techeer.hackathon.domain.restaurant.entity.Restaurant;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class RestaurantMapper {
    public Restaurant toEntity(RestaurantCreate request) {
        return Restaurant.builder()
                        .category(request.getCategory())
                        .name(request.getName())
                        .build();
    }

    public RestaurantResponse toDto(Restaurant restaurant) {

        return RestaurantResponse.builder()
                .category(restaurant.getCategory().name())
                .name(restaurant.getName())
                .createdAt(restaurant.getCreatedAt())
                        .build();
    }

    public List<RestaurantResponse> toDtoList(List<Restaurant> list) {
        return list.stream().map(this::toDto).collect(Collectors.toList());
    }
}
