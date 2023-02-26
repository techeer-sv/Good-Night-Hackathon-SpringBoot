package com.techeer.goodnighthackathonspringboot.domain.restaurant.dto;


import com.techeer.goodnighthackathonspringboot.domain.restaurant.entity.RestaurantCategory;
import lombok.*;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class RestaurantInfo {
    private String name;
    private RestaurantCategory category;
}
