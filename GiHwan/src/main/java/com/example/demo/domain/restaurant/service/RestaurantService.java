package com.example.demo.domain.restaurant.service;

import com.example.demo.domain.restaurant.dao.RestaurantRepository;
import com.example.demo.domain.restaurant.dto.RestaurantCreateRequest;
import com.example.demo.domain.restaurant.dto.RestaurantInfo;
import com.example.demo.domain.restaurant.dto.RestaurantUpdateRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.example.demo.domain.restaurant.entity.Restaurant;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class RestaurantService {

    private final RestaurantRepository restaurantRepository;

    @Transactional
    public void createRestaurant(RestaurantCreateRequest restaurantCreateRequest) {
        Restaurant restaurant = mapRestaurantEntityCreateRequestToRestaurant(restaurantCreateRequest);
        restaurantRepository.save(restaurant);

    }

    @Transactional
    public RestaurantInfo updateRestaurant(RestaurantUpdateRequest restaurantUpdateRequest){
        Restaurant restaurant = restaurantRepository.findById(restaurantUpdateRequest.getId())
                .orElseThrow(EntityNotFoundException::new);

        restaurant.update(restaurantUpdateRequest.getCategory());

        Restaurant savedRestaurant = restaurantRepository.save(restaurant);

        return mapRestaurantEntityToRestaurantInfo(savedRestaurant);
    }

    @Transactional(readOnly = true)
    public RestaurantInfo getRestaurantDetail(Long id){
        Restaurant restaurant = restaurantRepository.findById(id)
                .orElseThrow(EntityNotFoundException::new);

        return mapRestaurantEntityToRestaurantInfo(restaurant);
    }

    @Transactional(readOnly = true)
    public List<RestaurantInfo> getRestaurantList(){
        return restaurantRepository.findAll().stream()
                .map(this::mapRestaurantEntityToRestaurantInfo)
                .collect(Collectors.toList());
    }



    public RestaurantInfo mapRestaurantEntityToRestaurantInfo(Restaurant restaurant){
        return RestaurantInfo.builder()
                .createdDate(restaurant.getCreatedAt())
                .category(restaurant.getCategory())
                .name(restaurant.getName())
                .build();
    }

    public Restaurant mapRestaurantEntityCreateRequestToRestaurant(RestaurantCreateRequest restaurantCreateRequest) {
        return Restaurant.builder()
                .category(restaurantCreateRequest.getCategory())
                .name(restaurantCreateRequest.getName())
                .build();
    }

}
