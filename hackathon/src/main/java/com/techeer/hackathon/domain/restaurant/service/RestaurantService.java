package com.techeer.hackathon.domain.restaurant.service;

import com.techeer.hackathon.domain.restaurant.domain.entity.Restaurant;
import com.techeer.hackathon.domain.restaurant.domain.repository.RestaurantRepository;
import com.techeer.hackathon.domain.restaurant.dto.RestaurantCreateRequestDto;
import com.techeer.hackathon.domain.restaurant.dto.RestaurantResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@RequiredArgsConstructor
public class RestaurantService {
    private final RestaurantRepository restaurantRepository;

    @Transactional
    public RestaurantResponseDto createRestaurant(RestaurantCreateRequestDto restaurantCreateRequestDto) {
        final Restaurant newRestaurant =
                Restaurant.builder()
                        .name(restaurantCreateRequestDto.getName())
                        .category(restaurantCreateRequestDto.getCategory())
                        .build();
        restaurantRepository.save(newRestaurant);

        return RestaurantResponseDto.builder()
                .name(newRestaurant.getName())
                .category(newRestaurant.getCategory())
                .createdDate(newRestaurant.getCreatedDate())
                .build();
    }


}
