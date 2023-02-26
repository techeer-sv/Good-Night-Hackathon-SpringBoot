package com.example.demo.domain.restaurant.service;

import com.example.demo.domain.restaurant.dto.request.RestaurantCreateRequest;
import com.example.demo.domain.restaurant.dto.response.RestaurantResponse;
import com.example.demo.domain.restaurant.dto.request.RestaurantSearchRequest;
import com.example.demo.domain.restaurant.dto.request.RestaurantUpdateRequest;

import java.util.List;

public interface RestaurantService {
    // 식당 생성
    public RestaurantResponse createRestaurant(RestaurantCreateRequest restaurantDto);

    // 식당 수정
    public RestaurantResponse updateRestaurant(Long id, RestaurantUpdateRequest restaurantDto);

    // 식당 조회 - list
    public List<RestaurantResponse> getRestaurants(RestaurantSearchRequest reviewDto);

    // 식당 조회 - detail
    public RestaurantResponse getRestaurantById(Long restaurantId);

    // 식당 삭제
    public Boolean deleteRestaurant(Long restaurantId);
}
