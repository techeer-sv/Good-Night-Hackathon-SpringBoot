package com.techeer.goodnighthackathonspringboot.domain.restaurant.controller;

import com.techeer.goodnighthackathonspringboot.domain.restaurant.domain.Restaurant;
import com.techeer.goodnighthackathonspringboot.domain.restaurant.dto.mapper.RestaurantMapper;
import com.techeer.goodnighthackathonspringboot.domain.restaurant.dto.request.RestaurantCreateRequest;
import com.techeer.goodnighthackathonspringboot.domain.restaurant.dto.request.RestaurantInfo;
import com.techeer.goodnighthackathonspringboot.domain.restaurant.dto.response.RestaurantResponseDto;
import com.techeer.goodnighthackathonspringboot.domain.restaurant.service.RestaurantService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RequestMapping("/api/v1/restaurant")
@RestController
@RequiredArgsConstructor
public class RestaurantController {
    private final RestaurantService restaurantService;
    private final RestaurantMapper mapper;

    @PostMapping
    public ResponseEntity<RestaurantResponseDto> registerRestaurant(
            @Valid @RequestBody RestaurantCreateRequest request) {
        Restaurant entity = restaurantService.create(mapper.toInfo(request));
        return ResponseEntity.ok(mapper.toResponseDto(entity));
    }
}
