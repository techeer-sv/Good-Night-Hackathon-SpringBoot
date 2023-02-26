package com.example.demo.domain.review.dto.request;

import com.example.demo.domain.review.entity.Review;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ReviewUpdateRequest {
    @NotBlank(message = "리뷰 제목은 빈칸일 수 없습니다")
    private String title;

    @NotNull(message = "리뷰 내용은 공백이 올 수 없습니다.")
    private String content;

}
