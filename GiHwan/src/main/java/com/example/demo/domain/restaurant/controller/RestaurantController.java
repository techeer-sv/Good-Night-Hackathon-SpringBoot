package com.example.demo.domain.restaurant.controller;

import com.example.demo.domain.restaurant.dto.RestaurantCreateRequest;
import com.example.demo.domain.restaurant.dto.RestaurantInfo;
import com.example.demo.domain.restaurant.dto.RestaurantUpdateRequest;
import com.example.demo.domain.restaurant.entity.Restaurant;
import com.example.demo.domain.restaurant.service.RestaurantService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/api")
@RequiredArgsConstructor
@RestController
public class RestaurantController {
    private final RestaurantService restaurantService;

    @PostMapping("/restaurant")
    public ResponseEntity<RestaurantInfo> createRestaurant(@RequestBody RestaurantCreateRequest restaurantCreateRequest){
        restaurantService.createRestaurant(restaurantCreateRequest);
        return ResponseEntity.ok(RestaurantInfo.builder()
                .createdDate(restaurantCreateRequest.getCreateDate())
                .category(restaurantCreateRequest.getCategory())
                .name(restaurantCreateRequest.getName())
                .build());
    }

    @PutMapping("/restaurant")
    public ResponseEntity<RestaurantInfo> updateRestaurant(@RequestBody RestaurantUpdateRequest restaurantUpdateRequest){
        RestaurantInfo restaurantInfo = restaurantService.updateRestaurant(restaurantUpdateRequest);
        return ResponseEntity.ok(restaurantInfo);
    }
}
