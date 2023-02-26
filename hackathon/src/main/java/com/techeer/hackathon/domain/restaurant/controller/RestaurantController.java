package com.techeer.hackathon.domain.restaurant.controller;

import com.techeer.hackathon.domain.restaurant.domain.entity.Restaurant;
import com.techeer.hackathon.domain.restaurant.dto.RestaurantCreateRequestDto;
import com.techeer.hackathon.domain.restaurant.dto.RestaurantResponseDto;
import com.techeer.hackathon.domain.restaurant.service.RestaurantService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RequestMapping("/api/v1/restaurants")
@RequiredArgsConstructor
@RestController
public class RestaurantController {
    private final RestaurantService restaurantService;

    @PostMapping("/create")
    public ResponseEntity<RestaurantResponseDto> createRestaurant(@RequestBody RestaurantCreateRequestDto restaurantCreateRequestDto) {
        restaurantService.createRestaurant(restaurantCreateRequestDto);
        return ResponseEntity.ok(RestaurantResponseDto.builder()
                .name(restaurantCreateRequestDto.getName())
                .category(restaurantCreateRequestDto.getCategory())
                .build());
    }

    @GetMapping("/{RestaurantId}")
    

    //READ
//    @GetMapping("/{id}")
//    public ResponseEntity<RestaurantResponseDto> getRestaurant(@PathVariable Long id) {
//        return restaurantService.getRestaurant(id);
//    }
//
//    //UPDATE
//    @PutMapping("/{id}")
//    public ResponseEntity<RestaurantResponseDto> updateRestaurant(@PathVariable Long id, @RequestBody RestaurantUpdateRequest restaurantUpdateRequest) {
//        return restaurantService.updateRestaurant(id, restaurantUpdateRequest);
//    }
//
//    //DELETE
//    @DeleteMapping("/{id}")
//    public void deleteRestaurant(@PathVariable Long id) {
//        restaurantService.deleteRestaurant(id);
//    }
//
//    //    READ ALL RESTAURANTS
//    @GetMapping("/all")
//    public List<Restaurant> getAllRestaurants()
//    {
//        return restaurantService.getAllRestaurants();
//    }
//
//    @GetMapping()
//    public List<Restaurant> getAllRestaurantsByCategory(@RequestParam String category)
//    {
//        return restaurantService.getAllRestaurantsByCategory(category);
//    }
}
