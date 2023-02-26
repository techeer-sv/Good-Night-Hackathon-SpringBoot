package com.techeer.hackathon.domain.restaurant.dto.mapper;

import com.techeer.hackathon.domain.restaurant.dto.RestaurantCreateDto;
import com.techeer.hackathon.domain.restaurant.dto.RestaurantResponseDto;
import com.techeer.hackathon.domain.restaurant.entity.Restaurant;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

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

    public List<RestaurantResponseDto> restaurantResponseListFromEntity(Page<Restaurant> restaurantPage){
        List<RestaurantResponseDto> restaurantResponseList = restaurantPage.stream().map(this::DtoFromEntity).collect(Collectors.toList());
        return restaurantResponseList;
    }
}
