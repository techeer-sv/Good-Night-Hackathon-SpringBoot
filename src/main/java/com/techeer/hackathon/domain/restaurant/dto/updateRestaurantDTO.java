package com.techeer.hackathon.domain.restaurant.dto;

import com.techeer.hackathon.domain.restaurant.entity.Restaurant;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
@Getter
@Builder
@AllArgsConstructor
public class updateRestaurant {
    private final Long id;
    private final Restaurant category;
}
