package com.example.demo.domain.restaurant.dto;

import com.example.demo.domain.restaurant.entity.RestaurantCategory;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;

@Builder
@Getter
@AllArgsConstructor
public class RestaurantInfo {
    private String name;
    private RestaurantCategory category;
    private LocalDateTime createdAt;
}
