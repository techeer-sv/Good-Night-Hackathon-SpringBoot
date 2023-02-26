package com.techeer.hackathon.domain.restaurant.controller;

import com.techeer.hackathon.domain.restaurant.dto.RestaurantCreateDto;
import com.techeer.hackathon.domain.restaurant.dto.RestaurantResponseDto;
import com.techeer.hackathon.domain.restaurant.dto.RestaurantUpdateDto;
import com.techeer.hackathon.domain.restaurant.dto.mapper.RestaurantMapper;
import com.techeer.hackathon.domain.restaurant.entity.Restaurant;
import com.techeer.hackathon.domain.restaurant.service.RestaurantService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RequestMapping("/api/v1/restaurant")
@RestController
@RequiredArgsConstructor
public class RestaurantController {
    private final RestaurantService R_Service;
    private final RestaurantMapper R_Mapper;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<RestaurantResponseDto> createRestaurant(
            @RequestBody @Valid RestaurantCreateDto restaurantCreateDto) {
        Restaurant insertRestaurant = R_Service.insertRestaurant(restaurantCreateDto);
        return new ResponseEntity(R_Mapper.DtoFromEntity(insertRestaurant), HttpStatus.CREATED);
    }

//    @GetMapping
//    @ResponseStatus(HttpStatus.OK)
//    public ResponseEntity<List<Restaurant>> findAllRestaurant(){ //List<RestaurantResponseDto>
//        List<Restaurant> restaurants = R_Service.findAllRestaurant();
//        //for문 사용
////        return new ResponseEntity<>(
////                restaurants.stream().map(R_Mapper::DtoFromEntity).collect(Collectors.toList())
////                , HttpStatus.OK);
//        return new ResponseEntity<>(restaurants, HttpStatus.OK);
//    }

    @GetMapping("/page")
    public ResponseEntity<List<RestaurantResponseDto>> getAllRestaurant(
            @RequestParam(defaultValue = "5") Integer size, @RequestParam(defaultValue = "0") Integer offset) {
        return ResponseEntity.ok(R_Service.findAllRestaurant(size, offset));
    }
//
    @GetMapping("/category")
    public ResponseEntity<Object> getRestaurantByCategory(
            @RequestParam("category") String category, @RequestParam(defaultValue = "10") Integer size,
            @RequestParam(defaultValue = "0") Integer offset) {
        return ResponseEntity.ok(R_Service.findRestaurantsByCategory(category, size, offset));
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<Restaurant> findOneRestaurant(@PathVariable Long id){
        Restaurant restaurant = R_Service.findOneRestaurant(id);
        return new ResponseEntity<>(restaurant, HttpStatus.OK);
    }

    @PutMapping
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<RestaurantResponseDto> updateRestaurant(@Valid @RequestBody RestaurantUpdateDto restaurantUpdate) {
        Restaurant updateRestaurant = R_Service.updateRestaurant(restaurantUpdate);
        return new ResponseEntity<>(R_Mapper.DtoFromEntity(updateRestaurant), HttpStatus.OK); }

    @DeleteMapping("/{id}")
    public void deleteRestaurant(@PathVariable Long id) {
        R_Service.deleteRestaurant(id);
    }

}