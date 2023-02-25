package com.example.hackathon.restaurant.dto;

import com.example.hackathon.restaurant.domain.entity.Category;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class RestaurantCreateDTO {
    private Category category;
    private String name;
}
