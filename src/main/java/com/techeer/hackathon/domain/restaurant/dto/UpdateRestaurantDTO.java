package com.techeer.hackathon.domain.restaurant.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Getter
@Builder
@AllArgsConstructor
public class UpdateRestaurantDTO {
    @NotNull
    private final String category;
    private final LocalDateTime updatedAt;
}
