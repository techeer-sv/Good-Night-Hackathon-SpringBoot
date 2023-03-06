package com.techeer.goodnight.domain.restaurant.controller;

import com.techeer.goodnight.domain.restaurant.service.RestaurantService;
import com.techeer.goodnight.domain.restaurant.dto.request.RestaruantCreateRequestDto;
import com.techeer.goodnight.domain.restaurant.dto.request.RestaruantUpdateRequestDto;
import com.techeer.goodnight.domain.restaurant.dto.response.RestaruantResponseDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Optional;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/restaurants")
public class RestaurantController {

    @Resource(name = "restaurantService")
    private final RestaurantService restaurantService;

    @GetMapping()
    public ResponseEntity<Page<RestaruantResponseDto>> get(
            @PageableDefault(sort ="id", direction = Sort.Direction.DESC)
            Pageable pageable,
            @RequestParam(value = "categoryName", required = false) Optional<String> categoryName
    ) {
        return new ResponseEntity<>(restaurantService.getRestaurants(pageable, categoryName), HttpStatus.OK);
    }


    @PostMapping()
    public ResponseEntity<RestaruantResponseDto> create(
            @RequestBody final RestaruantCreateRequestDto createRestaurantReq
    ) {
        return new ResponseEntity<>(restaurantService.create(createRestaurantReq), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<RestaruantResponseDto> getRestaurantById(@PathVariable final long id) {
        return new ResponseEntity<>(restaurantService.findById(id), HttpStatus.OK);
    }


    @PatchMapping("/{id}")
    public ResponseEntity<RestaruantResponseDto> patchRestaurantById(
            @PathVariable final long id,
            @RequestBody final RestaruantUpdateRequestDto patchRestaurantReq) {
        return new ResponseEntity<>(restaurantService.patchById(id, patchRestaurantReq), HttpStatus.OK);
    }


    @DeleteMapping("/{id}")
    public void deleteRestaurantById(@PathVariable final long id) {
        restaurantService.deleteById(id);
    }
}