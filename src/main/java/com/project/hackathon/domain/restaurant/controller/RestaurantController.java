package com.project.hackathon.domain.restaurant.controller;

import javax.validation.Valid;

import com.project.hackathon.domain.restaurant.dto.RestaurantCreateRequest;
import com.project.hackathon.domain.restaurant.dto.RestaurantDetailResponse;
import com.project.hackathon.domain.restaurant.dto.RestaurantUpdateRequest;
import com.project.hackathon.domain.restaurant.entity.Category;
import com.project.hackathon.domain.restaurant.entity.Restaurant;
import com.project.hackathon.domain.restaurant.service.RestaurantService;
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

    @PatchMapping("/patch")
    public ResponseEntity<RestaurantDetailResponse> updateRestaurant(
            @Validated @RequestBody RestaurantUpdateRequest request
    ) {
        RestaurantDetailResponse restaurantDetailResponse = restaurantService.update(request);
        return ResponseEntity.ok(restaurantDetailResponse);
    }


//    @DeleteMapping("/{boardId}")
//    public ResponseEntity<ResultResponse> deleteBoard(
//            @PathVariable Long boardId, @RequestParam Long userId) {
//        boardService.deleteBoard(boardId, userId);
//
//        return ResponseEntity.ok(ResultResponse.of(ResultCode.BOARD_DELETE_SUCCESS, new Object()));
//    }
}