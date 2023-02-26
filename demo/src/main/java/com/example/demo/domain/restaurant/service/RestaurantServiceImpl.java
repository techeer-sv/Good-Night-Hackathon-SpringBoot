package com.example.demo.domain.restaurant.service;

import com.example.demo.domain.restaurant.dto.request.RestaurantCreateRequest;
import com.example.demo.domain.restaurant.dto.response.RestaurantResponse;
import com.example.demo.domain.restaurant.dto.request.RestaurantSearchRequest;
import com.example.demo.domain.restaurant.dto.request.RestaurantUpdateRequest;
import com.example.demo.domain.restaurant.entity.Restaurant;
import com.example.demo.domain.restaurant.map.ToEntity;
import com.example.demo.domain.restaurant.map.ToResponse;
import com.example.demo.domain.restaurant.repository.RestaurantRepository;
import javax.persistence.EntityNotFoundException;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
public class RestaurantServiceImpl implements RestaurantService{

    @Autowired
    RestaurantRepository repository;

    private final ToEntity entity;

    private final ToResponse response;

    public RestaurantServiceImpl(ToEntity entity, ToResponse response){
        this.entity = entity;
        this.response = response;
    }

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
            restaurants = repository.findAllNotDeleted();
        } else {
            restaurants = repository.findAllByCategoryNotDeleted(reviewDto.getCategory().toString());
        }
        List<RestaurantResponse> restaurantResponses = new ArrayList<>();
        restaurants.forEach(s -> restaurantResponses.add(response.toResponse(s)));
        return restaurantResponses;
    }

    @Transactional(readOnly = true)
    public RestaurantResponse getRestaurantById(Long restaurantId) {
        Restaurant restaurant = repository.findByIdNotDeleted(restaurantId);
        if (restaurant == null) {
            return null;
        }
        return response.toResponse(restaurant);
    }

    @Transactional
    public Boolean deleteRestaurant(Long restaurantId) {
        Restaurant restaurant = repository.findById(restaurantId).orElseThrow(EntityNotFoundException::new);
        if(restaurant != null && restaurant.isDeleted() == false) {
            repository.deleteById(restaurantId);
            return true;
        }
        return false;
    }

}
