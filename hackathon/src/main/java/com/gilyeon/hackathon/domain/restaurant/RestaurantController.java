package com.gilyeon.hackathon.domain.restaurant;

import com.gilyeon.hackathon.domain.restaurant.dto.RestaurantCreateRequest;
import com.gilyeon.hackathon.domain.restaurant.dto.RestaurantInfo;
import com.gilyeon.hackathon.domain.restaurant.dto.RestaurantUpdateRequest;
import com.gilyeon.hackathon.domain.review.dto.ReviewInfo;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/api")
@RequiredArgsConstructor
@RestController
public class RestaurantController {
    private final RestaurantService restaurantService;

    @PostMapping("/restaurant/create")
    public ResponseEntity<RestaurantInfo> createRestaurant(@RequestBody RestaurantCreateRequest restaurantCreateRequest) {
        restaurantService.createRestaurant(restaurantCreateRequest);
        return ResponseEntity.ok(RestaurantInfo.builder()
                .name(restaurantCreateRequest.getName())
                .category(restaurantCreateRequest.getCategory())
                .createdAt(restaurantCreateRequest.getCreatedAt())
                .updatedAt(restaurantCreateRequest.getUpdatedAt())
                .build());
    }

    @GetMapping("/restaurant/{id}")
    public ResponseEntity<RestaurantInfo> getRestaurant(@PathVariable Long id) {
        RestaurantInfo restaurantInfo = restaurantService.getRestaurantDetail(id);
        return ResponseEntity.ok(restaurantInfo);
    }

    @GetMapping("/restaurants")
    public ResponseEntity<List<RestaurantInfo>> getRestaurantListByPagination(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size) {
        List<RestaurantInfo> restaurantInfoList = restaurantService.getRestaurantListByPagination(page, size);
        return ResponseEntity.ok(restaurantInfoList);
    }

    @PutMapping("/restaurant/edit")
    public ResponseEntity<RestaurantInfo> updateRestaurant(@RequestBody RestaurantUpdateRequest restaurantUpdateRequest) {
        RestaurantInfo restaurantInfo = restaurantService.updateRestaurant(restaurantUpdateRequest);
        return ResponseEntity.ok(restaurantInfo);
    }

    @DeleteMapping("restaurant/delete/{id}")
    public ResponseEntity<String> deleteRestaurant(@PathVariable Long id) {
        restaurantService.deleteRestaurant(id);
        return ResponseEntity.ok(id+"번 식당이 삭제되었습니다.");
    }
}