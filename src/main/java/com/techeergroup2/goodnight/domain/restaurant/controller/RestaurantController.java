package com.techeergroup2.goodnight.domain.restaurant.controller;

import com.techeergroup2.goodnight.domain.restaurant.domain.Restaurant;
import com.techeergroup2.goodnight.domain.restaurant.dto.CreatedRestaurantRequest;
import com.techeergroup2.goodnight.domain.restaurant.dto.RestaurantDtoResponse;
import com.techeergroup2.goodnight.domain.restaurant.dto.RestaurantUpdateRequest;
import com.techeergroup2.goodnight.domain.restaurant.dto.RestaurantUpdateResponse;
import com.techeergroup2.goodnight.domain.review.dto.ReviewCreateRequest;
import com.techeergroup2.goodnight.domain.restaurant.service.RestaurantService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@RequestMapping("/api/v1/restaurants")
@RestController
public class RestaurantController {

    private final RestaurantService restaurantService;

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

//UPDATE
    @PutMapping("/{id}")
    public RestaurantUpdateResponse updateRestaurant(@PathVariable Long id, @RequestBody RestaurantUpdateRequest restaurantUpdateRequest) {
        return restaurantService.updateRestaurant(id, restaurantUpdateRequest);
    }

//DELETE
    @DeleteMapping("/{id}")
    public void deleteRestaurant(@PathVariable Long id) {
        restaurantService.deleteRestaurant(id);
    }

//    READ ALL RESTAURANTS
//    @GetMapping("/all")
//    public List<Restaurant> getAllRestaurants()
//    {
//        return restaurantService.getAllRestaurants();
//    }

    @GetMapping()
    public List<Restaurant> getAllRestaurantsByCategory(@RequestParam Optional<String> category)
    {
        return restaurantService.getAllRestaurantsByCategory(category);
    }

}
