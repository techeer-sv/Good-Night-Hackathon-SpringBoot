package com.techeer.hackathon.domain.review.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ReviewPreviewInfo {
    private String restaurantName;
    private String title;

    @Builder
    public ReviewPreviewInfo(String restaurantName, String title) {
        this.restaurantName = restaurantName;
        this.title = title;
    }
}
