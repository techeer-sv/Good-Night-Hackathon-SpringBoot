package com.techeer.hackathon.domain.restaurant.service;

import com.techeer.hackathon.domain.restaurant.dto.RestaurantCreateDto;
import com.techeer.hackathon.domain.restaurant.dto.mapper.RestaurantMapper;
import com.techeer.hackathon.domain.restaurant.entity.Restaurant;
import com.techeer.hackathon.domain.restaurant.repository.RestaurantRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RestaurantService {
    private final RestaurantRepository R_Repository;
    private final RestaurantMapper R_Mapper;

    public Restaurant insertRestaurant(RestaurantCreateDto restaurantCreateDto) {
        return R_Repository.save(R_Mapper.DtoToEntity(restaurantCreateDto));
    }


}
