package com.techeer.goodnighthackathonspringboot.global.error;

import lombok.AllArgsConstructor;
import lombok.Getter;

/** Enum Naming Format : {주체}_{이유} message format: 동사 명사형으로 마무리 */
@Getter
@AllArgsConstructor
public enum ErrorCode {
    // Global
    INTERNAL_SERVER_ERROR(500, "G001", "서버 오류"),
    INPUT_INVALID_VALUE(400, "G002", "잘못된 입력"),
    // Restaurant
    NOT_FOUND_RESTAURANT_ENTITY(400, "R001", "존재하지 않는 restaurant 입니다."),
    ;

    private final int status;
    private final String code;
    private final String message;
}
