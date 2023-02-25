package com.techeer.hackathon.global.result;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ResultCode {

    EXAMPLE_RESULT_CODE("EXAM1", "예시용"),
    RESTAURANT_CREATE_SUCCESS("R001", "레스토랑 생성 성공"),
    CHANGE_CATEGORY_SUCCESS("R002", "카테고리 변경 성공");

    private final String code;
    private final String message;
}
