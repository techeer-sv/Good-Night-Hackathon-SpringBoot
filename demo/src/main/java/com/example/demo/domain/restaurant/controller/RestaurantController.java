package com.example.demo.domain.restaurant.controller;

import com.example.demo.domain.restaurant.dto.request.RestaurantCreateRequest;
import com.example.demo.domain.restaurant.dto.response.RestaurantResponse;
import com.example.demo.domain.restaurant.dto.request.RestaurantSearchRequest;
import com.example.demo.domain.restaurant.dto.request.RestaurantUpdateRequest;
import com.example.demo.domain.restaurant.service.RestaurantServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/api/v1/restaurants")
@RequiredArgsConstructor
@RestController
public class RestaurantController {

    private final RestaurantServiceImpl restaurantService;

    @PostMapping()
    public ResponseEntity<RestaurantResponse> createRestaurant(@RequestBody RestaurantCreateRequest restaurantCreateRequest) {
        RestaurantResponse restaurantResponse = restaurantService.createRestaurant(restaurantCreateRequest);
        return ResponseEntity.ok(restaurantResponse);
    }

    @GetMapping()
    public ResponseEntity<List<RestaurantResponse>> getRestaurants(@ModelAttribute RestaurantSearchRequest restaurantSearchRequest) {
        List<RestaurantResponse> restaurantResponses = restaurantService.getRestaurants(restaurantSearchRequest);
        return ResponseEntity.ok(restaurantResponses);
    }

    @GetMapping("/{id}")
    public ResponseEntity<RestaurantResponse> getRestaurantById(@PathVariable Long id) {
        RestaurantResponse restaurantResponse = restaurantService.getRestaurantById(id);
        return ResponseEntity.ok(restaurantResponse);
    }

    @PutMapping("/{id}")
    public ResponseEntity<RestaurantResponse> updateRestaurant(@PathVariable Long id, @RequestBody RestaurantUpdateRequest restaurantUpdateRequest) {
        RestaurantResponse restaurantResponse = restaurantService.updateRestaurant(id, restaurantUpdateRequest);
        return ResponseEntity.ok(restaurantResponse);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> deleteRestaurant(@PathVariable Long id) {
        Boolean bool = restaurantService.deleteRestaurant(id);
        return ResponseEntity.ok(bool);
    }
}
