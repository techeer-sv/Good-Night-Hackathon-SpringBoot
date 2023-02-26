package com.techeer.goodnighthackathonspringboot.domain.restaurant.dto.response;

import com.techeer.goodnighthackathonspringboot.domain.restaurant.domain.Category;
import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class RestaurantResponseDto {
    private String name;
    private String category;
}
