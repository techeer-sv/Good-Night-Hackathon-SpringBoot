package com.techeer.hackathon.domain.restaurant.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import javax.validation.constraints.NotNull;

@Getter
@Builder
@AllArgsConstructor
public class UpdateRestaurantDTO {
    @NotNull
    private final String category;
}
