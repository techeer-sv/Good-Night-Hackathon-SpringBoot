package com.example.hackathon.restaurant.dto;

import com.example.hackathon.restaurant.domain.entity.Category;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import javax.validation.constraints.NotBlank;

@Getter
@Builder
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class RestaurantCreateDTO {

    @NotBlank(message = "유효한 카테고리로 요청하기 바랍니다.")
    private Category category;
    private String name;
}
