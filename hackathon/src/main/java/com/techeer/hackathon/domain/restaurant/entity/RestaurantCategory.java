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
            System.out.println(cat.getCategory());
            if(cat.toString().equals(category)) return true;
        }
        return false;
    }

    public static RestaurantCategory getCategory(String category) {
        for (RestaurantCategory cat : RestaurantCategory.values()) {
            System.out.println(cat.getCategory());
            if(cat.toString().equals(category)) return cat;
        }
        return null;
    }
}
