package com.example.demo.domain.restaurant.dto.request;

import com.example.demo.domain.restaurant.entity.Restaurant;
import com.example.demo.global.enumpkg.Category;
import lombok.*;

import javax.validation.constraints.NotNull;

@Getter
@Builder
@AllArgsConstructor
@ToString
public class RestaurantSearchRequest {
    private Category category;

}
