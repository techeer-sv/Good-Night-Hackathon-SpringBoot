package com.techeer.goodnighthackathonspringboot.domain.restaurant.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Builder
@AllArgsConstructor
@Getter
@NoArgsConstructor
public class RestaurantPageInfo {
    private List<RestaurantInfo> restaurantInfos;
}
