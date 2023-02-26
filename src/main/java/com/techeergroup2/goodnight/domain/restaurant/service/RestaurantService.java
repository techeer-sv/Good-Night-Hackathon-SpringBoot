package com.techeergroup2.goodnight.domain.restaurant.service;

import com.techeergroup2.goodnight.domain.restaurant.domain.Restaurant;
import com.techeergroup2.goodnight.domain.restaurant.dto.CreatedRestaurantRequest;
import com.techeergroup2.goodnight.domain.restaurant.dto.RestaurantDtoResponse;
import com.techeergroup2.goodnight.domain.restaurant.dto.RestaurantUpdateRequest;
import com.techeergroup2.goodnight.domain.restaurant.dto.RestaurantUpdateResponse;
import com.techeergroup2.goodnight.domain.restaurant.repository.RestaurantRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Transactional
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
        restaurantRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("No restaurant with id " + id));
        restaurantRepository.deleteById(id);
    }

    public List<Restaurant> getAllRestaurants() {
        return restaurantRepository.findAll();
    }

    public List<Restaurant> getAllRestaurantsByCategory(Optional<String> category) {
        if (category.isPresent()) {
            return restaurantRepository.findAllByCategory(category.get());
        }
        return restaurantRepository.findAll();
    }
}
