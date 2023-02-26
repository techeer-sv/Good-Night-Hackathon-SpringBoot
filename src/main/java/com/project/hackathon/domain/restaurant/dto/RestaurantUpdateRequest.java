package com.project.hackathon.domain.restaurant.dto;

import com.project.hackathon.domain.restaurant.entity.Category;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Getter
@Builder
@AllArgsConstructor
public class RestaurantUpdateRequest {
    @NotBlank(message = "레스토랑 제목은 빈칸일 수 없습니다.")
    private final String title;

    @NotNull(message = "레스토랑 카테고리는 공백이 올 수 없습니다.")
    private final Category category;

    private final LocalDateTime createdAt;
}