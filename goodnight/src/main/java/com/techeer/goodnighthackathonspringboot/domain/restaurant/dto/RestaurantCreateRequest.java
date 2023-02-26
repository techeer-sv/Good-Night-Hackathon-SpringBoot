package com.techeer.goodnighthackathonspringboot.domain.restaurant.dto;

import jdk.jfr.Category;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import javax.validation.constraints.NotNull;

@Builder
@AllArgsConstructor
@Getter
@RequiredArgsConstructor
public class RestaurantCreateRequest {
    @NotNull(message = "레스토랑 이름은 필수입니다.")
    private String name;
    @NotNull(message = "레스토랑 카테고리는 필수입니다.")
    private Category category;

}
