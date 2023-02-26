package com.example.demo.domain.restaurant.controller;

import com.example.demo.domain.restaurant.dto.RestaurantCreateRequest;
import com.example.demo.domain.restaurant.dto.RestaurantInfo;
import com.example.demo.domain.restaurant.dto.RestaurantUpdateRequest;
import com.example.demo.domain.restaurant.entity.Restaurant;
import com.example.demo.domain.restaurant.entity.RestaurantCategory;
import com.example.demo.domain.restaurant.service.RestaurantService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @GetMapping("/restaurants/{id}")
    public ResponseEntity<RestaurantInfo> getRestaurant(@PathVariable Long id){
        RestaurantInfo restaurantInfo = restaurantService.getRestaurantDetail(id);

        return ResponseEntity.ok(restaurantInfo);
    }

    @GetMapping("/restaurants/list")
    public ResponseEntity<List<RestaurantInfo>> getRestaurantsList(){
        List<RestaurantInfo> restaurantInfoList = restaurantService.getRestaurantList();
        return ResponseEntity.ok(restaurantInfoList);
    }

    @GetMapping("/restaurants/category_list")
    public ResponseEntity<List<RestaurantInfo>> getRestaurantsListCategory(
            @RequestParam RestaurantCategory category
            ){
        List<RestaurantInfo> restaurantInfoList = restaurantService.getRestaurantListCategory(category);
        return ResponseEntity.ok(restaurantInfoList);
    }

    @DeleteMapping("/restaurants/{id}")
    public ResponseEntity<String> deleteRestaurant(@PathVariable Long id){
        restaurantService.deleteRestaurant(id);
        return ResponseEntity.ok("레스토랑이 삭제되었습니다.");
    }
}
