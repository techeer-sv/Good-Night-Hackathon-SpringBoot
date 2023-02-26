package com.project.hackathon.domain.restaurant.controller;

import javax.validation.Valid;
import com.project.hackathon.domain.restaurant.dto.RestaurantCreateRequest;
import com.project.hackathon.domain.restaurant.dto.RestaurantDetailResponse;
import com.project.hackathon.domain.restaurant.dto.RestaurantUpdateRequest;
import com.project.hackathon.domain.restaurant.entity.Category;
import com.project.hackathon.domain.restaurant.entity.Restaurant;
import com.project.hackathon.domain.restaurant.service.RestaurantService;
import com.project.hackathon.global.dto.ResultResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RequestMapping("/api/v1/restaurant")
@RequiredArgsConstructor
@RestController
public class RestaurantController {

    private final RestaurantService restaurantService;
    @PostMapping("/create")
    public ResponseEntity<RestaurantDetailResponse> createRestaurant(
            @Validated @RequestBody RestaurantCreateRequest request
            ) {
        RestaurantDetailResponse restaurantDetailResponse = restaurantService.create(request);
        return ResponseEntity.ok(restaurantDetailResponse);
    }

    @GetMapping("/list")
    public ResponseEntity<List<Restaurant>> getAllRestaurants() {
        List<Restaurant> restaurants = restaurantService.getAllRestaurants();
        return ResponseEntity.ok(restaurants);
    }

    @GetMapping("/list/{category}")
    public ResponseEntity<List<RestaurantDetailResponse>> loadRestaurantByCategory(@PathVariable Category category) {
        List<RestaurantDetailResponse> restaurantDetailResponses = restaurantService.getRestaurantsByCategory(category);
        return ResponseEntity.ok(restaurantDetailResponses);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<RestaurantDetailResponse> updateRestaurant(
            @PathVariable Long id,
            @Valid @RequestBody RestaurantUpdateRequest request) {
        RestaurantDetailResponse restaurantDetailResponse = restaurantService.update(id, request);
        return ResponseEntity.ok(restaurantDetailResponse);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<RestaurantDetailResponse> deleteRestaurant(
            @PathVariable Long id) {
        restaurantService.delete(id);
        String message = ResultResponse.RESTAURANT_DELETE_SUCCESS.getMessage();
        RestaurantDetailResponse response = new RestaurantDetailResponse(message);
        return ResponseEntity.ok(response);
    }
}