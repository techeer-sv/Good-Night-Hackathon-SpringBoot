package com.techeer.hackaton.domain.restaurant.dto;

import com.techeer.hackaton.domain.restaurant.entity.RestaurantCategory;
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

    private LocalDateTime createdDate;
}
