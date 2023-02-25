package com.techeer.hackathon.domain.restaurant.dto;

import com.techeer.hackathon.domain.restaurant.entity.RestaurantCategory;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
@AllArgsConstructor
public class RestaurantInfo {
    private String name;
    private RestaurantCategory category;
}
