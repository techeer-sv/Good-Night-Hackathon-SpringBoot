package com.gilyeon.hackathon.domain.restaurant.dto;

import com.gilyeon.hackathon.domain.restaurant.entity.RestaurantCategory;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@Builder
@AllArgsConstructor
public class RestaurantUpdateRequest {
    // restaurant update는 id와 category만 사용. - category만 변경가능
    private final Long id;
    private final RestaurantCategory category;
    private LocalDateTime updatedAt;
}