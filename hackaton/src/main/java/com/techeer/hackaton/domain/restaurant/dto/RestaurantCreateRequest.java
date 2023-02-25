package com.techeer.hackaton.domain.restaurant.dto;

import com.techeer.hackaton.domain.restaurant.entity.RestaurantCategory;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Getter
@Builder
@AllArgsConstructor
public class RestaurantCreateRequest {
    private final LocalDateTime createDate;

    private final String name;

    private final RestaurantCategory category;
}
