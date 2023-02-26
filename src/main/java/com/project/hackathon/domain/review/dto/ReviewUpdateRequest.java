package com.project.hackathon.domain.review.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import javax.validation.constraints.NotBlank;
import java.time.LocalDateTime;

@Getter
@Builder
@AllArgsConstructor
public class ReviewUpdateRequest {

    @NotBlank(message = "리뷰 제목은 빈칸일 수 없습니다.")
    private final String title;

    @NotBlank(message = "리뷰 내용은 빈칸일 수 없습니다.")
    private final String content;

    private final LocalDateTime createdAt;
}