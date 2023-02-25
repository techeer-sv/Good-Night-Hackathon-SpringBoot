package com.techeer.hackathon.domain.restaurant.controller;

import com.techeer.hackathon.domain.restaurant.dto.RestaurantChange;
import com.techeer.hackathon.domain.restaurant.dto.RestaurantCreate;
import com.techeer.hackathon.domain.restaurant.service.RestaurantService;
import com.techeer.hackathon.global.result.ResultCode;
import com.techeer.hackathon.global.result.ResultResponse;
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
    public ResponseEntity<ResultResponse> registerRestaurant(
            @RequestBody RestaurantCreate request) {
        restaurantService.createRestaurant(request);
        return ResponseEntity.ok(ResultResponse.of(ResultCode.RESTAURANT_CREATE_SUCCESS));
    }

    @PatchMapping
    public ResponseEntity<ResultResponse> changeRestaurantCategory(
            @RequestBody RestaurantChange request) {
        restaurantService.changeCategory(request);
        return ResponseEntity.ok(ResultResponse.of(ResultCode.CHANGE_CATEGORY_SUCCESS));
    }
}
