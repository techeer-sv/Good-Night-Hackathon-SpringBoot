package com.techeer.hackathon.domain.restaurant.controller;

import com.techeer.hackathon.domain.restaurant.dto.InquiryRestaurantDTO;
import com.techeer.hackathon.domain.restaurant.dto.RegisterRestaurantDTO;
import com.techeer.hackathon.domain.restaurant.dto.mapper.RestaurantMapper;
import com.techeer.hackathon.domain.restaurant.entity.Restaurant;
import com.techeer.hackathon.domain.restaurant.repository.RepositoryRestaurant;
import com.techeer.hackathon.domain.restaurant.service.ServiceRestaurant;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/api/v1/restaurant")
@RestController
@RequiredArgsConstructor
public class ControllerRestaurant {
    private final ServiceRestaurant Res_Service;
    private final RestaurantMapper Res_Mapper;

    private final RepositoryRestaurant Res_Repo;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<InquiryRestaurantDTO> createRestaurant(
            @RequestBody @Valid RegisterRestaurantDTO registerRestaurantDTO) {
        Restaurant insertRestaurant = Res_Service.insertRestaurant(registerRestaurantDTO);
        return new ResponseEntity(Res_Mapper.DtoFromEntity(insertRestaurant), HttpStatus.CREATED);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<InquiryRestaurantDTO> getAllRestaurants() {
        List<Restaurant> restaurants = Res_Repo.findByDeletedFalse();
        return restaurants.stream()
                .map(Res_Mapper::DtoFromEntity)
                .collect(Collectors.toList());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteRestaurant(@PathVariable Long id) {
        Res_Service.deleteRestaurant(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/category")
    public List<InquiryRestaurantDTO> getRestaurantsByCategory(String category) {
        List<Restaurant> restaurants = Res_Repo.findByCategoryAndDeletedFalse(category);
        return restaurants.stream().map(Res_Mapper::DtoFromEntity).collect(Collectors.toList());
    }
}
