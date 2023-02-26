package com.example.demo.domain.review.dto.request;

import com.example.demo.domain.restaurant.entity.Restaurant;
import com.example.demo.domain.review.entity.Review;
import com.example.demo.global.enumpkg.Category;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

import javax.validation.constraints.NotBlank;

@Getter
@Builder
@AllArgsConstructor
@ToString
public class ReviewCreateRequest {
    private final Restaurant restaurant;

    @NotBlank(message = "리뷰 제목은 빈칸일 수 없습니다")
    private final String title;

    @NotBlank(message = "리뷰 내용은 공백이 올 수 없습니다.")
    private final String content;

}
