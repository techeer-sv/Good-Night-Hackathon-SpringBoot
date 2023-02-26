package com.example.hackathon.restaurant.dto;

import com.example.hackathon.restaurant.domain.entity.Restaurant;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Builder
@Data
public class RestaurantResponse {

    private Integer id;

    private String name;

    private String category;

    private Boolean isDeleted;

    private LocalDateTime createdAt;

    public static RestaurantResponse of(
            Restaurant entity
    ) {
        return RestaurantResponse.builder()
                .id(entity.getId())
                .name(entity.getName())
                .category(entity.getCategory())
                .isDeleted(entity.getIsDeleted())
                .createdAt(entity.getCreatedAt())
                .build();
    }
}
