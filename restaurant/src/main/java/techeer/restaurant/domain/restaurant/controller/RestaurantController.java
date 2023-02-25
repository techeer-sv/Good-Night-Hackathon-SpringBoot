package techeer.restaurant.domain.restaurant.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import techeer.restaurant.domain.restaurant.dto.RestaurantCreateRequest;
import techeer.restaurant.domain.restaurant.dto.RestaurantInfo;
import techeer.restaurant.domain.restaurant.dto.RestaurantInfoList;
import techeer.restaurant.domain.restaurant.entity.Restaurant;
import techeer.restaurant.domain.restaurant.service.RestaurantService;
import techeer.restaurant.global.domain.response.ResultResponse;

import javax.validation.Valid;

import java.util.List;

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
        return ResponseEntity.ok(ResultResponse.of(RESTAURANT_CREATE_SUCCESS, restaurantInfo));
    }

    @GetMapping
    public ResponseEntity<ResultResponse> getAllRestaurant() {
        RestaurantInfoList restaurantInfoList = restaurantService.getAllRestaurants();
        return ResponseEntity.ok(ResultResponse.of(GET_ALL_RESTAURANT_SUCCESS, restaurantInfoList));
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

}
