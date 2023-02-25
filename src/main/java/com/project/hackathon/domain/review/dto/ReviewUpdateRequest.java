package com.project.hackathon.domain.review.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Getter
@Builder
@AllArgsConstructor
public class ReviewUpdateRequest {
    @NotNull(message = "리뷰 Id는 공백이 올 수 없습니다.")
    private final String id;

    @NotBlank(message = "리뷰 제목은 빈칸일 수 없습니다.")
    private final String title;

    @NotBlank(message = "리뷰 내용은 빈칸일 수 없습니다.")
    private final String context;

    @NotBlank(message = "리뷰 레스토랑은 빈칸일 수 없습니다.")
    private final String restaurant;
}