package com.example.demo.domain.restaurant.dto.request;

import com.example.demo.global.enumpkg.Category;
import com.example.demo.domain.restaurant.entity.Restaurant;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Getter
@Builder
@AllArgsConstructor
@ToString
public class RestaurantCreateRequest {
    @NotBlank(message = "식당 이름은 빈칸일 수 없습니다")
    private final String name;

    @NotNull(message = "식당 카테고리는 공백이 올 수 없습니다.")
    private final Category category;

}
