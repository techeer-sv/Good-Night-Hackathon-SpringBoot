package com.techeer.hackaton.domain.restaurant.dto;

import com.techeer.hackaton.domain.restaurant.entity.RestaurantCategory;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Getter
@Builder
@AllArgsConstructor
public class RestaurantCreateRequest {
    @NotBlank(message = "식당 이름은 빈칸일 수 없습니다")
    private final String name;

    @NotNull(message = "식당 카테고리는 공백이 올 수 없습니다.")
    private final RestaurantCategory category;
}
