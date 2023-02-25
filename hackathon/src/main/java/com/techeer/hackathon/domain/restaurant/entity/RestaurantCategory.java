package com.techeer.hackathon.domain.restaurant.entity;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum RestaurantCategory {
    KOREAN_RESTAURANT("한식"),
    CHINESE_RESTAURANT("중식"),
    JAPANESE_RESTAURANT("일식");

    private final String category;

    public static Boolean isValidCategory(String category) {
        for (RestaurantCategory cat : RestaurantCategory.values()) {
            if(!cat.category.equals(category)) return false;
        }
        return true;
    }
}
