package com.techeer.hackathon.domain.restaurant.controller;

import com.techeer.hackathon.domain.restaurant.dto.InquiryRestaurantDTO;
import com.techeer.hackathon.domain.restaurant.dto.RegisterRestaurantDTO;
import com.techeer.hackathon.domain.restaurant.dto.mapper.RestaurantMapper;
import com.techeer.hackathon.domain.restaurant.entity.Restaurant;
import com.techeer.hackathon.domain.restaurant.service.ServiceRestaurant;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@Controller
@RequestMapping("/api/v1/restaurant")
@RestController
@RequiredArgsConstructor
public class ControllerRestaurant {
    private final ServiceRestaurant Res_Service;
    private final RestaurantMapper Res_Mapper;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<InquiryRestaurantDTO> createRestaurant(
            @RequestBody @Valid RegisterRestaurantDTO registerRestaurantDTO) {
        Restaurant insertRestaurant = Res_Service.insertRestaurant(registerRestaurantDTO);
        return new ResponseEntity(Res_Mapper.DtoFromEntity(insertRestaurant), HttpStatus.CREATED);
    }
}
