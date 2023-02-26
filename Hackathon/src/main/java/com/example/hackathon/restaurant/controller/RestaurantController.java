package com.example.hackathon.restaurant.controller;

import com.example.hackathon.global.dto.ResultResponse;
import com.example.hackathon.global.dto.code.ResultCode;
import com.example.hackathon.restaurant.dto.RestaurantChange;
import com.example.hackathon.restaurant.dto.RestaurantCreateDTO;
import com.example.hackathon.restaurant.service.RestaurantService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/restaurant")
@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
public class RestaurantController {
    private final RestaurantService restaurantService;

    @PostMapping
    public ResponseEntity<ResultResponse> registerRestaurant(@RequestBody RestaurantCreateDTO request) {
        restaurantService.createRestaurant(request);
        return ResponseEntity.ok(ResultResponse.of(ResultCode.RESTAURANT_CREATE_SUCCESS));
    }

    @PatchMapping
    public ResponseEntity<ResultResponse> changeRestaurantCategory (@RequestBody RestaurantChange request){
        restaurantService.changeRestaurantCategory(request);
        return  ResponseEntity.ok(ResultResponse.of(ResultCode.RESTAURANT_CATEGORY_CHANGE_SUCCESS));
    }
}
