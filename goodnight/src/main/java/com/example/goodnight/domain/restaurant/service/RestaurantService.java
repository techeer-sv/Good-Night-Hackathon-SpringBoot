package com.example.goodnight.domain.restaurant.service;

import com.example.goodnight.domain.restaurant.domain.Restaurant;
import com.example.goodnight.domain.restaurant.dto.request.RestaurantDto;
import com.example.goodnight.domain.restaurant.dto.response.RestaurantResDto;
import com.example.goodnight.domain.restaurant.repository.RestaurantRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class RestaurantService {
    private final RestaurantRepository restaurantRepository;

    public RestaurantResDto find(Long id) {
        Restaurant restaurant = restaurantRepository.findById(id).orElseThrow(null);
        RestaurantResDto dto = RestaurantResDto.builder()
                .restaurantName(restaurant.getRestaurantName())
                .category(restaurant.getCategory())
                .createdAt(restaurant.getCreatedAt())
                .build();
        return dto;
    }

    public List<Restaurant> findAll() {
        return restaurantRepository.findAll();
    }

    public List<Restaurant> findAllByCategory(String category) {
        return restaurantRepository.findAllByCategory(category);
    }

    public void registration(RestaurantDto dto) {
        Restaurant restaurant = Restaurant.builder()
                .restaurantName(dto.getRestaurantName())
                .category(dto.getCategory())
                .build();
        restaurantRepository.save(restaurant);
    }

    public void delete(Long id) {
        Restaurant restaurant = restaurantRepository.findById(id).orElseThrow(null);
        restaurant.delete();
    }

}
