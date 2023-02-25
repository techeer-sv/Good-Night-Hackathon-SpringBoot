package com.techeergroup2.goodnight.domain.restaurant.controller;

import com.techeergroup2.goodnight.domain.restaurant.domain.Restaurant;
import com.techeergroup2.goodnight.domain.restaurant.dto.CreatedRestaurantRequest;
import com.techeergroup2.goodnight.domain.restaurant.dto.RestaurantDtoResponse;
import com.techeergroup2.goodnight.domain.restaurant.service.RestaurantService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@RequestMapping("/restaurants")
@RestController
public class RestaurantController {

    private final RestaurantService restaurantService;

    @GetMapping
    public String getRestaurants() {
        return "hello";
    }
//CREATE
    @PostMapping
    public RestaurantDtoResponse createRestaurant(@RequestBody CreatedRestaurantRequest createdRestaurantRequest) {
        return restaurantService.createRestaurant(createdRestaurantRequest);
    }
//READ
    @GetMapping("/{id}")
    public RestaurantDtoResponse getRestaurant(@PathVariable Long id) {
        return restaurantService.getRestaurant(id);
    }
}
