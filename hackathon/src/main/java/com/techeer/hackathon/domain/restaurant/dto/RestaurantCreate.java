package com.techeer.hackathon.domain.restaurant.dto;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.techeer.hackathon.domain.restaurant.entity.RestaurantCategory;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class RestaurantCreate {
    private RestaurantCategory category;
    private String name;

    @JsonCreator
    public RestaurantCreate(@JsonProperty("name") String name, @JsonProperty("category") String category) {
        this.name = name;
        if(!RestaurantCategory.isValidCategory(category.toUpperCase())) this.category = null;
        else this.category = RestaurantCategory.valueOf(category.toUpperCase());
    }
}
