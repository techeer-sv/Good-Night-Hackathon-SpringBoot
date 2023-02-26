package com.project.hackathon.domain.restaurant.service;

import com.project.hackathon.domain.restaurant.dto.RestaurantCreateRequest;
import com.project.hackathon.domain.restaurant.dto.RestaurantDetailResponse;
import com.project.hackathon.domain.restaurant.dto.RestaurantUpdateRequest;
import com.project.hackathon.domain.restaurant.entity.Category;
import com.project.hackathon.domain.restaurant.entity.Restaurant;
import com.project.hackathon.domain.restaurant.repository.RestaurantRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

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

    @Transactional(readOnly = true)
    public List<RestaurantDetailResponse> getRestaurantsByCategory(Category category) {
        List<Restaurant> restaurants = restaurantRepository.findByCategory(category);
        List<RestaurantDetailResponse> restaurantDetailResponses = new ArrayList<>();
        for(Restaurant restaurant : restaurants) {
            restaurantDetailResponses.add(RestaurantDetailResponse.builder()
                    .id(restaurant.getId())
                    .title(restaurant.getTitle())
                    .category(restaurant.getCategory())
                    .build());
        }
        return restaurantDetailResponses;
    }

    @Transactional
    public RestaurantDetailResponse update(RestaurantUpdateRequest restaurantUpdateRequest) {
        Restaurant restaurant =
                Restaurant.builder()
                        .title(restaurantUpdateRequest.getTitle())
                        .category(restaurantUpdateRequest.getCategory())
                        .build();
        restaurantRepository.save(restaurant);

        return new RestaurantDetailResponse(
                restaurant.getId(),
                restaurant.getTitle(),
                restaurant.getCategory(),
                restaurant.getCreatedAt(),
                restaurant.getUpdatedAt());
    }

//    public void deleteRestaurant(Long restaurantId) {
//        Restaurant restaurant = RestaurantRepository.findRestaurantById(restaurantId).orElseThrow(null);
//        restaurant.deleteRestaurant();
//        restaurantRepository.save(restaurant);
//    }
}