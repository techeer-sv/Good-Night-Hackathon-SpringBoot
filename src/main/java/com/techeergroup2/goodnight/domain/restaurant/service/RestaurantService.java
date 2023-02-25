package com.techeergroup2.goodnight.domain.restaurant.service;

import com.techeergroup2.goodnight.domain.restaurant.domain.Restaurant;
import com.techeergroup2.goodnight.domain.restaurant.dto.CreatedRestaurantRequest;
import com.techeergroup2.goodnight.domain.restaurant.dto.RestaurantDtoResponse;
import com.techeergroup2.goodnight.domain.restaurant.dto.RestaurantUpdateRequest;
import com.techeergroup2.goodnight.domain.restaurant.dto.RestaurantUpdateResponse;
import com.techeergroup2.goodnight.domain.restaurant.repository.RestaurantRepository;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;

@AllArgsConstructor
@Service
public class RestaurantService {
    private final RestaurantRepository restaurantRepository;

    public RestaurantDtoResponse createRestaurant(CreatedRestaurantRequest createdRestaurantRequest) {
        return restaurantRepository.save(createdRestaurantRequest.toEntity()).toDto();
    }

    public RestaurantDtoResponse getRestaurant(Long id) {
        return restaurantRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("No restaurant with id " + id)).toDto();
    }


    public RestaurantUpdateResponse updateRestaurant(Long id, RestaurantUpdateRequest restaurantUpdateRequest) {
        Restaurant restaurant = restaurantRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("No restaurant with id " + id));
        restaurant.updateCategory(restaurantUpdateRequest.getCategory());
        restaurantRepository.save(restaurant);
        return restaurant.toUpdateDto();
    }

    public void deleteRestaurant(Long id) {
        restaurantRepository.deleteById(id);
    }
}
