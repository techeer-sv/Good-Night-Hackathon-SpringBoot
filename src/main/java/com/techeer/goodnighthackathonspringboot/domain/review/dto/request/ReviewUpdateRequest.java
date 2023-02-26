package com.techeer.goodnighthackathonspringboot.domain.review.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Builder
@AllArgsConstructor
@Getter
@RequiredArgsConstructor
public class ReviewUpdateRequest {
    @NotNull(message = "레스토랑 id는 필수입니다.")
    private Long restaurantId;
    @NotNull(message = "리뷰 id는 필수입니다.")
    private Long id;
    @NotBlank(message = "리뷰 제목은 필수입니다.")
    private String title;
    @NotBlank(message = "리뷰 내용은 필수입니다.")
    private String contents;
}
