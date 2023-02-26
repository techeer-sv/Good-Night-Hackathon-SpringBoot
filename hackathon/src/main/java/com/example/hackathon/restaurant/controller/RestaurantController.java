package com.example.hackathon.restaurant.controller;

import com.example.hackathon.restaurant.dto.RestaurantRequest;
import com.example.hackathon.restaurant.dto.RestaurantResponse;
import com.example.hackathon.restaurant.service.RestaurantService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/restaurants")
@RequiredArgsConstructor
public class RestaurantController {

    private final RestaurantService service;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public RestaurantResponse save(
            @Validated @RequestBody RestaurantRequest request
    ) {
        return service.save(request);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<RestaurantResponse> findAll() {
        return service.findAll();
    }

    @GetMapping("/category")
    @ResponseStatus(HttpStatus.OK)
    public List<RestaurantResponse> findAllByCategory(
            @RequestParam String category
    ) {
        return service.findAllByCategory(category);
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public RestaurantResponse findById(
            @PathVariable Integer id
    ) {
        return service.findById(id);
    }

    @PatchMapping("/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    public RestaurantResponse updateCategory(
            @PathVariable Integer id,
            @RequestParam String category
    ) {
        return service.updateCategory(id, category);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(
            @PathVariable Integer id
    ) {
        service.delete(id);
    }
}
