package com.project.hackathon.domain.restaurant.service;

import com.project.hackathon.domain.restaurant.dto.RestaurantCreateRequest;
import com.project.hackathon.domain.restaurant.dto.RestaurantDetailResponse;
import com.project.hackathon.domain.restaurant.dto.RestaurantInfo;
import com.project.hackathon.domain.restaurant.dto.RestaurantUpdateRequest;
import com.project.hackathon.domain.restaurant.entity.Category;
import com.project.hackathon.domain.restaurant.entity.Restaurant;
import com.project.hackathon.domain.restaurant.repository.RestaurantRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class RestaurantService {
    private final RestaurantRepository restaurantRepository;

    public RestaurantDetailResponse create(RestaurantCreateRequest restaurantCreateRequest) {
        Restaurant newRestaurant =
                Restaurant.builder()
                        .title(restaurantCreateRequest.getTitle())
                        .category(restaurantCreateRequest.getCategory())
                        .build();

        restaurantRepository.save(newRestaurant);

        return RestaurantDetailResponse.builder()
                .id(newRestaurant.getId())
                .title(newRestaurant.getTitle())
                .category(newRestaurant.getCategory())
                .createdAt(newRestaurant.getCreatedAt())
                .build();
    }

    @Transactional
    public List<Restaurant> getAllRestaurants() {
        return restaurantRepository.findAll();
    }

    @Transactional
    public RestaurantDetailResponse getCategoryDetail(Category category) {
        Restaurant restaurant = restaurantRepository.findRestaurantByCategory(category).orElseThrow(null);
        return
                RestaurantDetailResponse.builder()
                .title(restaurant.getTitle())
                .category(restaurant.getCategory())
                .build();
    }

    public RestaurantDetailResponse getBoardListPage(int page, int size) {
        final Pageable pageable = PageRequest.of(page, size);
        Page<Restaurant> restaurantPageInfoList =
                restaurantRepository.findRestaurantWithPagination(pageable);
        return new RestaurantDetailResponse();
    }

    @Transactional
    public RestaurantDetailResponse updateRestaurant(RestaurantUpdateRequest restaurantUpdateRequest) {
        Long id = restaurantUpdateRequest.getId();
        Restaurant restaurant =
                restaurantRepository.findRestaurantById(id).orElseThrow(null);

        return RestaurantDetailResponse.builder()
                .title(restaurant.getTitle())
                .category(restaurant.getCategory())
                .build();
    }

//    public void deleteRestaurant(Long restaurantId) {
//        Restaurant restaurant = RestaurantRepository.findRestaurantById(restaurantId).orElseThrow(null);
//        restaurant.deleteRestaurant();
//        restaurantRepository.save(restaurant);
//    }
}