package com.techeer.goodnight.domain.restaurant.controller;

import com.techeer.goodnight.domain.restaurant.dto.mapper.RestaruantMapper;
import com.techeer.goodnight.domain.restaurant.dto.request.RestaruantCreateRequestDto;
import com.techeer.goodnight.domain.restaurant.dto.request.RestaruantUpdateRequestDto;
import com.techeer.goodnight.domain.restaurant.dto.response.RestaruantResponseDto;
import com.techeer.goodnight.domain.restaurant.entity.Restaruant;
import com.techeer.goodnight.domain.restaurant.service.RestaurantService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api/v1/restaurant")
@RequiredArgsConstructor
public class RestaurantController {
    private final RestaurantService service;
    private final RestaruantMapper mapper;

    @PostMapping
    public ResponseEntity<RestaruantResponseDto> create(
            @RequestBody RestaruantCreateRequestDto dto
    ){
        Restaruant entity = service.create(dto);
        RestaruantResponseDto response = mapper.toResponseDto(entity);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<RestaruantResponseDto> getOne(@PathVariable UUID id) {
        return ResponseEntity
                .ok(mapper.toResponseDto(service.findById(id)));
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable UUID id) {
        service.deleteById(id);
        return ResponseEntity
                .noContent()
                .build();
    }

}