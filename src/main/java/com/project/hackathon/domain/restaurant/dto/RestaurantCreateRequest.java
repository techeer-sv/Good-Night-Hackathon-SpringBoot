package com.project.hackathon.domain.restaurant.dto;

import com.project.hackathon.domain.restaurant.entity.Category;
import lombok.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Getter
@Builder
@Data
public class RestaurantCreateRequest {
    @NotBlank(message = "레스토랑 제목은 빈칸일 수 없습니다.")
    private String title;

    @NotNull(message = "레스토랑 카테고리는 공백이 올 수 없습니다.")
    private Category category;
}