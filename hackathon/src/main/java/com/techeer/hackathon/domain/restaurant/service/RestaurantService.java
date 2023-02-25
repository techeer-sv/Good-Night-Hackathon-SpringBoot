package com.techeer.hackathon.domain.restaurant.service;

import com.techeer.hackathon.domain.restaurant.entity.Restaurant;
import com.techeer.hackathon.domain.restaurant.error.RestaurantDuplicateException;
import com.techeer.hackathon.domain.restaurant.repository.RestaurantRepository;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
public class RestaurantService {
    private final RestaurantRepository restaurantRepository;

    public void createRestaurant(Restaurant restaurant) {
        if(restaurantRepository.existsByName(restaurant.getName())) {
            throw new RestaurantDuplicateException();
        }
        restaurantRepository.save(restaurant);
    }
}
