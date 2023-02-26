package com.project.hackathon.global.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ErrorResponse {
    // Global
    INTERNAL_SERVER_ERROR(500, "G001", "서버 오류"),

    // Restaurant
    RESTAURANT_NOT_FOUND(400, "RT001", "레스토랑을 찾을 수 없습니다."),

    // Review
    REVIEW_NOT_FOUND(400, "RV001", "리뷰를 찾을 수 없습니다."),
    CANT_DELETE_REVIEW(400, "RV003", "이미 삭제된 이미지입니다.")
    ;

    private final int status;
    private final String code;
    private final String message;
}
