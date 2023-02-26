package com.techeer.goodnighthackathonspringboot.domain.restaurant.dto;

import jdk.jfr.Category;
import lombok.Builder;
import lombok.Getter;

import java.util.Date;

@Builder
@Getter
public class RestaurantDto {
    private String storename;
    private String category;
}
