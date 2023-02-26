package com.techeer.goodnighthackathonspringboot.domain.restaurant.service;

import com.techeer.goodnighthackathonspringboot.domain.restaurant.dto.RestaurantCreateRequest;
import com.techeer.goodnighthackathonspringboot.domain.restaurant.entity.Restaurant;
import com.techeer.goodnighthackathonspringboot.domain.restaurant.repository.RestaurantRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
public class RestaurantService {
    private final RestaurantRepository restaurantRepository;
    //등록 - 삭제

    public void create(RestaurantCreateRequest restaurantCreateRequest) {
        Restaurant restaurant = mapRestaurantEntityToRestaurantInfo(restaurantCreateRequest);
        restaurantRepository.save(restaurant);
    }
    public Restaurant mapRestaurantEntityToRestaurantInfo(RestaurantCreateRequest restaurantCreateRequest) {
        return Restaurant.builder()
                .name(restaurantCreateRequest.getName())
                .category(restaurantCreateRequest.getCategory())
                .build();
    }

    public void delete(Long id){
        restaurantRepository.deleteById(id);
    }

}
