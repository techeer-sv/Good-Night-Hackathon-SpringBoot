package com.project.hackathon.domain.review.dto;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import javax.validation.constraints.NotBlank;

@Getter
@Builder
@Data
public class ReviewCreateRequest {
    @NotBlank(message = "리뷰 제목은 빈칸일 수 없습니다.")
    private String title;

    @NotBlank(message = "리뷰 내용은 빈칸일 수 없습니다.")
    private String content;

    @NotBlank(message = "리뷰 내용은 빈칸일 수 없습니다.")
    private String restaurant;

}