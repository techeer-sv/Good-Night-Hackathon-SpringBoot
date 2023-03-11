package com.techeergroup2.goodnight.domain.restaurant.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
public class RestaurantUpdateResponse {
    private String name;
    private String category;
}
