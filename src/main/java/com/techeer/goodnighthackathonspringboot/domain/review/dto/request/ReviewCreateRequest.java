package com.techeer.goodnighthackathonspringboot.domain.review.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Builder
@AllArgsConstructor
@Getter
@RequiredArgsConstructor
public class ReviewCreateRequest {
    @NotNull(message = "레스토랑 id는 필수입니다.")
    private Long restaurantId;
    @NotEmpty(message = "리뷰 타이틀은 필수입니다.")
    private String title;
    @NotEmpty(message = "리뷰 내용은 필수입니다.")
    private String contents;
}
