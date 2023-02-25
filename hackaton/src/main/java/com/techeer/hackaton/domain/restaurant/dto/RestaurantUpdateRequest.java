package com.techeer.hackaton.domain.restaurant.dto;

import com.techeer.hackaton.domain.restaurant.entity.RestaurantCategory;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
@AllArgsConstructor
public class RestaurantUpdateRequest {
    private final Long id;
    private final RestaurantCategory category;
}
