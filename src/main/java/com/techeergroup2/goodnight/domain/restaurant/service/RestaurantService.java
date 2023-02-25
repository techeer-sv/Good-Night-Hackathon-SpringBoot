package com.techeergroup2.goodnight.domain.restaurant.service;

import com.techeergroup2.goodnight.domain.restaurant.domain.Restaurant;
import com.techeergroup2.goodnight.domain.restaurant.dto.CreatedRestaurantRequest;
import com.techeergroup2.goodnight.domain.restaurant.dto.RestaurantDtoResponse;
import com.techeergroup2.goodnight.domain.restaurant.repository.RestaurantRepository;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;

@AllArgsConstructor
@Service
public class RestaurantService {
    private final RestaurantRepository restaurantRepository;

    public RestaurantDtoResponse createRestaurant(CreatedRestaurantRequest createdRestaurantRequest) {
        return restaurantRepository.save(createdRestaurantRequest.toEntity()).toDto();
    }
}
