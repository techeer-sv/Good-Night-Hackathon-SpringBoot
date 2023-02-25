package com.techeer.hackathon.domain.restaurant.controller;

import com.techeer.hackathon.domain.restaurant.entity.Restaurant;
import com.techeer.hackathon.domain.restaurant.service.RestaurantService;
import com.techeer.hackathon.global.result.ResultCode;
import com.techeer.hackathon.global.result.ResultResponse;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/restaurant")
@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
public class RestaurantController {

    private final RestaurantService restaurantService;

    @PostMapping
    public ResponseEntity<ResultResponse> registerRestaurant(
            @RequestBody Restaurant restaurant) {
        restaurantService.createRestaurant(restaurant);
        return ResponseEntity.ok(ResultResponse.of(ResultCode.RESTAURANT_CREATE_SUCCESS));
    }
}
