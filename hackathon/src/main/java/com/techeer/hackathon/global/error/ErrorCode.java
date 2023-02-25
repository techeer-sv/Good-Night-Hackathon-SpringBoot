package com.techeer.hackathon.global.error;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ErrorCode {
    // Global
    INTERNAL_SERVER_ERROR(500, "G001", "서버 오류"),
    INPUT_INVALID_VALUE(409, "G002", "잘못된 입력"),

    // Restaurant
    RESTAURANT_DUPLICATION_ERROR(409, "R001", "레스토랑 이름이 중복됩니다."),
    INVALID_CATEGORY_ERROR(400, "R002", "잘못된 카테고리 이름입니다.");

    private final int status;
    private final String code;
    private final String message;
}

