package com.techeer.hackaton.domain.restaurant.controller;

import com.techeer.hackaton.domain.restaurant.dto.RestaurantCreateRequest;
import com.techeer.hackaton.domain.restaurant.dto.RestaurantInfo;
import com.techeer.hackaton.domain.restaurant.service.RestaurantService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RequestMapping("/api")
@RequiredArgsConstructor
@RestController
public class RestaurantController {
    private final RestaurantService restaurantService;

    @PostMapping("/restaurant")
    public ResponseEntity<RestaurantInfo> createRestaurant(@Valid @RequestBody RestaurantCreateRequest restaurantCreateRequest) {
        restaurantService.createRestaurant(restaurantCreateRequest);
        return ResponseEntity.ok(RestaurantInfo.builder()
                        .category(restaurantCreateRequest.getCategory())
                        .name(restaurantCreateRequest.getName())
                .build());
    }

    @GetMapping("/restaurant/{id}")
    public ResponseEntity<RestaurantInfo> getRestaurant(@PathVariable Long id) {
        RestaurantInfo restaurantInfo = restaurantService.getRestaurantDetail(id);

        return ResponseEntity.ok(restaurantInfo);
    }
}
