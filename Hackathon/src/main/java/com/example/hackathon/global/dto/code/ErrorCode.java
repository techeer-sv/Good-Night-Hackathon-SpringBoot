package com.example.hackathon.global.dto.code;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ErrorCode {
    // 전체
    INTERNAL_SERVER_ERROR(500, "G001", "서버 오류"),
    INPUT_INVALID_VALUE(409, "G002", "잘못된 입력"),

    // 레스토랑
    RESTAURANT_DUPLICATION_ERROR(409, "ROO1", "레스토랑 이름이 중복됩니다.");

    private final int status;
    private final String code;
    private final String messege;
}
