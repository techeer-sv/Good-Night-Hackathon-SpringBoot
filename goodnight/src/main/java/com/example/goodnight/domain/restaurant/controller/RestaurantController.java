package com.example.goodnight.domain.restaurant.controller;

import com.example.goodnight.domain.restaurant.domain.Restaurant;
import com.example.goodnight.domain.restaurant.dto.request.RestaurantDto;
import com.example.goodnight.domain.restaurant.dto.response.RestaurantResDto;
import com.example.goodnight.domain.restaurant.service.RestaurantService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class RestaurantController {
    private final RestaurantService restaurantService;

    @GetMapping("/api/v1/restaurants/{id}")
    public RestaurantResDto getRestaurantV1(@PathVariable Long id) {
        return restaurantService.find(id);
    }

    @GetMapping("/api/v1/restaurants")
    public List<Restaurant> getAllRestaurantV1() {
        return restaurantService.findAll();
    }

    @GetMapping("/api/v1/restaurants/category")
    public List<Restaurant> getByCategoryRestaurantV1(@RequestParam(value = "category") String category) {
        return restaurantService.findAllByCategory(category);
    }

    @PostMapping("/api/v1/restaurants")
    public void 료(@RequestBody RestaurantDto dto) {
        restaurantService.registration(dto);
    }

    @DeleteMapping("/api/v1/restaurants/{id}")
    public void deleteRestaurantV1(@PathVariable Long id) {
        restaurantService.delete(id);
    }
}
