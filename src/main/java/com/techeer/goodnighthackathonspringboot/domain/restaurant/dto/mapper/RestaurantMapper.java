package com.techeer.goodnighthackathonspringboot.domain.restaurant.dto.mapper;

import com.techeer.goodnighthackathonspringboot.domain.restaurant.domain.Category;
import com.techeer.goodnighthackathonspringboot.domain.restaurant.domain.Restaurant;
import com.techeer.goodnighthackathonspringboot.domain.restaurant.dto.request.RestaurantCreateRequest;
import com.techeer.goodnighthackathonspringboot.domain.restaurant.dto.request.RestaurantInfo;
import com.techeer.goodnighthackathonspringboot.domain.restaurant.dto.response.RestaurantResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
public class RestaurantMapper {

    public RestaurantResponseDto toResponseDto(Restaurant entity) {
        return RestaurantResponseDto.builder()
                .name(entity.getName())
                .category(entity.getCategory().toString())
                .build();
    }

    public RestaurantInfo toInfo(RestaurantCreateRequest request) {
        return RestaurantInfo.builder()
                .name(request.getName())
                .category(Category.valueOf(request.getCategory()))
                .build();
    }

    public Restaurant toEntity(RestaurantCreateRequest request) {
        return Restaurant.builder()
                .name(request.getName())
                .category(Category.valueOf(request.getCategory()))
                .build();
    }

    public RestaurantInfo toInfo(Restaurant entity) {
        return RestaurantInfo.builder()
                .name(entity.getName())
                .category(entity.getCategory())
                .build();
    }

}
