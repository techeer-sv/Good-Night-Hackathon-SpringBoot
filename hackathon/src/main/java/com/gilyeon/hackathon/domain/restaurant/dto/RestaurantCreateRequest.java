package com.gilyeon.hackathon.domain.restaurant.dto;

import com.gilyeon.hackathon.domain.restaurant.entity.RestaurantCategory;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@Builder
@AllArgsConstructor
public class RestaurantCreateRequest {
    private final String name;
    private final RestaurantCategory category;
    private final LocalDateTime createDate;
}
