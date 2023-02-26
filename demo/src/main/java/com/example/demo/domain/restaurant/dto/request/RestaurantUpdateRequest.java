package com.example.demo.domain.restaurant.dto.request;

import com.example.demo.domain.restaurant.entity.Restaurant;
import com.example.demo.global.enumpkg.Category;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RestaurantUpdateRequest {
    @NotNull(message = "식당 카테고리는 공백이 올 수 없습니다.")
    private Category category;

}
