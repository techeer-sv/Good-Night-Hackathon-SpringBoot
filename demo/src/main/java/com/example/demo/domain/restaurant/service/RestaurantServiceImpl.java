package com.example.demo.domain.restaurant.service;

import com.example.demo.domain.restaurant.dto.request.RestaurantCreateRequest;
import com.example.demo.domain.restaurant.dto.response.RestaurantResponse;
import com.example.demo.domain.restaurant.dto.request.RestaurantSearchRequest;
import com.example.demo.domain.restaurant.dto.request.RestaurantUpdateRequest;
import com.example.demo.domain.restaurant.entity.Restaurant;
import com.example.demo.domain.restaurant.map.ToRestaurantEntity;
import com.example.demo.domain.restaurant.map.ToRestaurantResponse;
import com.example.demo.domain.restaurant.repository.RestaurantRepository;
import javax.persistence.EntityNotFoundException;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class RestaurantServiceImpl implements RestaurantService{

    @Autowired
    RestaurantRepository repository;

    private final ToRestaurantEntity entity;

    private final ToRestaurantResponse response;

    @Transactional
    public RestaurantResponse createRestaurant(RestaurantCreateRequest restaurantDto) {
        Restaurant restaurant = entity.toCreateEntity(restaurantDto);
        Restaurant savedRestaurant = repository.save(restaurant);
        return response.toResponse(savedRestaurant);
    }

    @Transactional
    public RestaurantResponse updateRestaurant(Long id, RestaurantUpdateRequest restaurantDto) {
        Restaurant restaurant = repository.findById(id).orElseThrow(EntityNotFoundException::new);

        restaurant.update(restaurantDto);
        Restaurant savedRestaurant = repository.save(restaurant);

        return response.toResponse(savedRestaurant);
    }

    @Transactional(readOnly = true)
    public List<RestaurantResponse> getRestaurants(RestaurantSearchRequest reviewDto) {
        List<Restaurant> restaurants;
        if(reviewDto.getCategory() == null) {
            restaurants = repository.findAllByIsDeletedFalse();
        } else {
            restaurants = repository.findAllByCategoryAndIsDeletedFalse(reviewDto.getCategory());
        }
        List<RestaurantResponse> restaurantResponses = new ArrayList<>();
        restaurants.forEach(s -> restaurantResponses.add(response.toResponse(s)));
        return restaurantResponses;
    }

    @Transactional(readOnly = true)
    public RestaurantResponse getRestaurantById(Long restaurantId) {
        Restaurant restaurant = repository.findByIdAndIsDeletedFalse(restaurantId);
        if (restaurant == null) {
            return null;
        }
        return response.toResponse(restaurant);
    }

    @Transactional
    public Boolean deleteRestaurant(Long restaurantId) {
        Restaurant restaurant = repository.findById(restaurantId).orElseThrow(EntityNotFoundException::new);
        if(restaurant != null && restaurant.isDeleted() == false) {
            repository.deleteByIdAndIsDeletedFalse(restaurantId);
            return true;
        }
        return false;
    }

}
