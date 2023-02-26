package com.example.hackathon.restaurant.domain.entity;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum Category {
    KOREAN_RESTAURANT("한식"),
    CHINESE_RESTAURANT("중식"),
    JAPANESE_RESTAURANT("일식");

    private final String category;

    // 카테고리가 있는지 판별
    public static boolean isVaildCategory(String category) {
        for(Category cat: Category.values()) {
            System.out.println(cat.getCategory());
            if(cat.toString().equals(category)) return true;
        }
        return false;
    }

    // 카테고리 이름 가져오기
    public static Category getCategory(String category) {
        for(Category cat: Category.values()) {
            System.out.println(cat.getCategory());
            if(cat.toString().equals(category)) return cat;
        }
        return null;
    }


}
