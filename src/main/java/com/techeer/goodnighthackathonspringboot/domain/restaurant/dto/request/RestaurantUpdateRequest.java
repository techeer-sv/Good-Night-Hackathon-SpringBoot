package com.techeer.goodnighthackathonspringboot.domain.restaurant.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import javax.validation.constraints.NotNull;

@Builder
@AllArgsConstructor
@Getter
@RequiredArgsConstructor
public class RestaurantUpdateRequest {
    @NotNull(message = "레스토랑 id는 필수입니다.")
    private  Long id;

    @NotNull(message = "레스토랑 카테고리는 필수입니다.")
    private String category;
}
