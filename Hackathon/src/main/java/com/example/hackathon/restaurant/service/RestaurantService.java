package com.example.hackathon.restaurant.service;

import com.example.hackathon.restaurant.RestaurantMapper;
import com.example.hackathon.restaurant.domain.repository.RestaurantRepository;
import com.example.hackathon.restaurant.dto.RestaurantCreateDTO;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
public class RestaurantService {
    private final RestaurantRepository restaurantRepository;
    private final RestaurantMapper restaurantMapper;

    public void createRestaurant(RestaurantCreateDTO restaurantCreateDTO) {
        restaurantRepository.save(restaurantMapper.toEntity(restaurantCreateDTO));
    }
}
