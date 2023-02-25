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
public class RestaurantChange {
    private Long id;
    private RestaurantCategory category;

    @JsonCreator
    public RestaurantChange(@JsonProperty("id") Long id, @JsonProperty("category") String category) {
        this.id = id;
        if(!RestaurantCategory.isValidCategory(category.toUpperCase())) this.category = null;
        else this.category = RestaurantCategory.valueOf(category.toUpperCase());
    }
}
