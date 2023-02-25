package com.techeer.goodnight.domain.restaurant.dto.response;

import com.techeer.goodnight.domain.restaurant.entity.Restaurant;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class RestaruantResponseDto {

    private long id;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;

    private String name;

    private String categoryName;

    @Builder
    public RestaruantResponseDto(Restaurant restaurant) {
        this.id = restaurant.getId();
        this.createdAt = restaurant.getCreatedAt();
        this.updatedAt = restaurant.getUpdatedAt();
        this.name = restaurant.getName();
        this.categoryName = restaurant.getCategoryName();
    }
}