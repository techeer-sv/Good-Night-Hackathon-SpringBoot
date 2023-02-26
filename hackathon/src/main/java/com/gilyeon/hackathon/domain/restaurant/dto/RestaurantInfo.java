package com.gilyeon.hackathon.domain.restaurant.dto;

import com.gilyeon.hackathon.domain.restaurant.entity.RestaurantCategory;

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
    private LocalDateTime updatedAt;
}