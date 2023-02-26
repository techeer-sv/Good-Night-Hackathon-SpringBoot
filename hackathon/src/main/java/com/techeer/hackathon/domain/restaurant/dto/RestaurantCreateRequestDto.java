package com.techeer.hackathon.domain.restaurant.dto;

import com.techeer.hackathon.domain.restaurant.domain.entity.Restaurant;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Builder
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class RestaurantCreateRequestDto {
    private String name;
    private String category;

}
