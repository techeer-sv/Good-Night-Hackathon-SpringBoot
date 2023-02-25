package techeer.restaurant.domain.restaurant.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import techeer.restaurant.domain.restaurant.dto.RestaurantCreateRequest;
import techeer.restaurant.domain.restaurant.dto.RestaurantInfo;
import techeer.restaurant.domain.restaurant.dto.RestaurantInfoList;
import techeer.restaurant.domain.restaurant.entity.Category;
import techeer.restaurant.domain.restaurant.entity.Restaurant;
import techeer.restaurant.domain.restaurant.service.RestaurantService;
import techeer.restaurant.global.domain.response.ResultResponse;

import javax.validation.Valid;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import static techeer.restaurant.global.domain.response.code.ResultCode.*;

@RequestMapping("/api/v1/restaurant")
@RestController
@RequiredArgsConstructor
public class RestaurantController {

    private final RestaurantService restaurantService;

    @PostMapping
    public ResponseEntity<ResultResponse> createRestaurant(
            @Valid @RequestBody RestaurantCreateRequest request) {
        RestaurantInfo restaurantInfo = restaurantService.createRestaurant(request);
        return ResponseEntity.ok(ResultResponse.of(CREATE_RESTAURANT_SUCCESS, restaurantInfo));
    }

    @GetMapping
    public ResponseEntity<ResultResponse> getAllRestaurant() {
        RestaurantInfoList restaurantInfoList = restaurantService.findAllRestaurants();
        return ResponseEntity.ok(ResultResponse.of(GET_ALL_RESTAURANT_SUCCESS, restaurantInfoList));
    }

    @GetMapping(params={"category"})
    public ResponseEntity<ResultResponse> findAllRestaurantByCategory(@RequestParam("category") String category) {
        RestaurantInfoList restaurantInfoList = restaurantService.findAllRestaurantsByCategory(Category.valueOf(category));
        return ResponseEntity.ok(ResultResponse.of(GET_CATEGORY_RESTAURANT_SUCCESS, restaurantInfoList));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ResultResponse> findRestaurantById(@PathVariable Long id) {
        RestaurantInfo restaurantInfo = restaurantService.findRestaurantInfoById(id);
        return ResponseEntity.ok(ResultResponse.of(GET_ONE_RESTAURANT_SUCCESS, restaurantInfo));
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<ResultResponse> deleteRestaurant(@PathVariable Long id) {
        restaurantService.deleteRestaurant(id);
        return ResponseEntity.ok(ResultResponse.of(DELETE_RESTAURANT_SUCCESS, ""));
    }

    @PatchMapping("/{id}")
    public ResponseEntity<ResultResponse> updateRestaurantCategory(
            @PathVariable Long id,
            @RequestBody Map<String,String> request
            ) {
        String category = request.get("category");
        restaurantService.updateRestaurantInfo(id, Category.valueOf(category));
        return ResponseEntity.ok(ResultResponse.of(UPDATE_RESTAURANT_SUCCESS, ""));
    }
}
