package com.techeer.goodnighthackathonspringboot.domain.restaurant.dto.mapper;

import com.techeer.goodnighthackathonspringboot.domain.restaurant.domain.Category;
import com.techeer.goodnighthackathonspringboot.domain.restaurant.domain.Restaurant;
import com.techeer.goodnighthackathonspringboot.domain.restaurant.dto.RestaurantPageInfo;
import com.techeer.goodnighthackathonspringboot.domain.restaurant.dto.request.RestaurantCreateRequest;
import com.techeer.goodnighthackathonspringboot.domain.restaurant.dto.RestaurantInfo;
import com.techeer.goodnighthackathonspringboot.domain.restaurant.dto.request.RestaurantUpdateRequest;
import com.techeer.goodnighthackathonspringboot.domain.restaurant.dto.response.RestaurantResponseDto;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class RestaurantMapper {

    public RestaurantResponseDto toResponseDto(Restaurant entity) {
        return RestaurantResponseDto.builder()
                .name(entity.getName())
                .category(entity.getCategory().toString())
                .build();
    }

    public RestaurantInfo mapCreateRequestToInfo(RestaurantCreateRequest request) {
        return RestaurantInfo.builder()
                .name(request.getName())
                .category(Category.valueOf(request.getCategory()))
                .build();
    }

    public RestaurantInfo mapUpdateRequestToInfo(RestaurantUpdateRequest request) {
        return RestaurantInfo.builder()
                .category(Category.valueOf(request.getCategory()))
                .build();
    }

    public Restaurant toEntity(RestaurantCreateRequest request) {
        return Restaurant.builder()
                .name(request.getName())
                .category(Category.valueOf(request.getCategory()))
                .build();
    }

    public RestaurantInfo mapEntityToInfo(Restaurant entity) {
        return RestaurantInfo.builder()
                .name(entity.getName())
                .category(entity.getCategory())
                .build();
    }

    public RestaurantPageInfo mapEntityToRestaurantPageInfo(Page<Restaurant> restaurantList) {
        List<RestaurantInfo> restaurantInfoList =
                restaurantList.stream().map(this::mapEntityToInfo).collect(Collectors.toList());
        return RestaurantPageInfo.builder().restaurantInfos(restaurantInfoList).build();
    }

}
