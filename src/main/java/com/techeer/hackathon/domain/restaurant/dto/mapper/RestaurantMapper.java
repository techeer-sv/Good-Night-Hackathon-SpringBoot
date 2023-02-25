package com.techeer.hackathon.domain.restaurant.dto.mapper;

import com.techeer.hackathon.domain.restaurant.dto.RestaurantCreateDto;
import com.techeer.hackathon.domain.restaurant.dto.RestaurantResponseDto;
import com.techeer.hackathon.domain.restaurant.entity.Restaurant;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
@Component
public class RestaurantMapper {
    public Restaurant DtoToEntity(RestaurantCreateDto restaurantCreateDto) {
        return Restaurant.builder()
                .name(restaurantCreateDto.getName())
                .category(restaurantCreateDto.getCategory())
                .build();
    }

    public RestaurantResponseDto DtoFromEntity(Restaurant restaurant) {
        return RestaurantResponseDto.builder()
                .id(restaurant.getId())
                .name(restaurant.getName())
                .category(restaurant.getCategory())
                .build();
    }

}
