package com.techeer.goodnighthackathonspringboot.domain.restaurant.controller;

import com.techeer.goodnighthackathonspringboot.domain.restaurant.dto.RestaurantPageInfo;
import com.techeer.goodnighthackathonspringboot.domain.restaurant.dto.mapper.RestaurantMapper;
import com.techeer.goodnighthackathonspringboot.domain.restaurant.dto.request.RestaurantCreateRequest;
import com.techeer.goodnighthackathonspringboot.domain.restaurant.dto.RestaurantInfo;
import com.techeer.goodnighthackathonspringboot.domain.restaurant.dto.request.RestaurantUpdateRequest;
import com.techeer.goodnighthackathonspringboot.domain.restaurant.service.RestaurantService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RequestMapping("/api/v1/restaurant")
@RestController
@RequiredArgsConstructor
public class RestaurantController {
    private final RestaurantService restaurantService;
    private final RestaurantMapper mapper;

    @PostMapping
    public ResponseEntity<RestaurantInfo> register(
            @Valid @RequestBody RestaurantCreateRequest request) {
        return ResponseEntity.ok(restaurantService.create(mapper.mapCreateRequestToInfo(request)));
    }

    @PutMapping
    public ResponseEntity<RestaurantInfo> update(
            @Valid @RequestBody RestaurantUpdateRequest request
    ){
        return ResponseEntity.ok(restaurantService.update(mapper.mapUpdateRequestToInfo(request)));
    }

    @GetMapping("/page")
    public ResponseEntity<RestaurantPageInfo> getRestaurantByPagination(
            @RequestParam(defaultValue = "0") int offset, @RequestParam(defaultValue = "10") int size){
        RestaurantPageInfo restaurantPageInfo = restaurantService.getRestaurantByPagination(offset, size);
        return ResponseEntity.ok(restaurantPageInfo);
    }


}
