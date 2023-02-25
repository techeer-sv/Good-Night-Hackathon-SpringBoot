package com.techeer.hackaton.domain.restaurant.service;

import com.techeer.hackaton.domain.restaurant.dto.RestaurantCreateRequest;
import com.techeer.hackaton.domain.restaurant.dto.RestaurantInfo;
import com.techeer.hackaton.domain.restaurant.entity.Restaurant;
import com.techeer.hackaton.domain.restaurant.repository.RestaurantRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;

@RequiredArgsConstructor
@Service
@Slf4j
public class RestaurantService {
    private final RestaurantRepository restaurantRepository;

    @Transactional
    public void createRestaurant(RestaurantCreateRequest restaurantCreateRequest) {
        Restaurant restaurant = mapRestaurantEntityCreateRequestToRestaurant(restaurantCreateRequest);
        restaurantRepository.save(restaurant);
    }


    @Transactional
    public RestaurantInfo getRestaurantDetail(Long id) {
        Restaurant foundRestaurant = restaurantRepository.findById(id)
                .orElseThrow(EntityNotFoundException::new);

        return mapRestaurantEntityToRestaurantInfo(foundRestaurant);
    }

    public Restaurant mapRestaurantEntityCreateRequestToRestaurant(RestaurantCreateRequest restaurantCreateRequest) {
        return Restaurant.builder()
                .category(restaurantCreateRequest.getCategory())
                .name(restaurantCreateRequest.getName())
                .build();
    }

    public RestaurantInfo mapRestaurantEntityToRestaurantInfo(Restaurant restaurant) {
        return RestaurantInfo.builder()
                .category(restaurant.getCategory())
                .name(restaurant.getName())
                .build();
    }

}
