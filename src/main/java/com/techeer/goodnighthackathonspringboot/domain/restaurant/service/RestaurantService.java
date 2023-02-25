package com.techeer.goodnighthackathonspringboot.domain.restaurant.service;

import com.techeer.goodnighthackathonspringboot.domain.restaurant.dao.RestaurantRepository;
import com.techeer.goodnighthackathonspringboot.domain.restaurant.domain.Restaurant;
import com.techeer.goodnighthackathonspringboot.domain.restaurant.dto.mapper.RestaurantMapper;
import com.techeer.goodnighthackathonspringboot.domain.restaurant.dto.request.RestaurantInfo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RestaurantService {
    private final RestaurantRepository restaurantRepository;
    private final RestaurantMapper mapper;

    public Restaurant create(RestaurantInfo restaurantInfo){
        Restaurant entity = Restaurant.builder()
                .name(restaurantInfo.getName())
                .category(restaurantInfo.getCategory())
                .build();
        return restaurantRepository.save(entity);
    }
}
