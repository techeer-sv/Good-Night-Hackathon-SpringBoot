package com.project.hackathon.domain.restaurant.dto;

import java.time.LocalDateTime;

import com.project.hackathon.domain.restaurant.entity.Category;
import lombok.*;

@Setter
@Builder
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class RestaurantDetailResponse {
    private Long id;

    // 레스토랑 이름
    private String title;
    // 레스토랑 카테고리
    private Category category;
    // 레스토랑 생성일자
    private LocalDateTime createdAt;
}
