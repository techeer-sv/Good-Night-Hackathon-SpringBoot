package com.example.hackathon.restaurant;

import com.example.hackathon.restaurant.domain.entity.Restaurant;
import com.example.hackathon.restaurant.dto.RestaurantCreateDTO;
import com.example.hackathon.restaurant.dto.RestaurantResponse;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class RestaurantMapper {
    public Restaurant toEntity (RestaurantCreateDTO request) {
        return Restaurant.builder()
                .category(request.getCategory())
                .name(request.getName())
                .build();
    }

    public RestaurantResponse toDto(Restaurant restaurant) {
        return RestaurantResponse.builder()
                .name(restaurant.getName())
                .category(restaurant.getCategory().name())
                .createdAt(restaurant.getCreatedDate())
                .build();
    }

    public List<RestaurantResponse> toDtoList (List<Restaurant> list) {
        // 스트림내 요소들에 대해 함수가 적용된 결과의 새로운 요소로 매핑해준다.
        return list.stream().map(this::toDto).collect(Collectors.toList());
    }
}
