package com.example.hackathon.global.dto.code;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ResultCode {
    
    // 레스토랑
    EXAMPLE_RESULT_CODE("EXAM1", "예시용"),
    RESTAURANT_CREATE_SUCCESS("R001", "레스토랑 생성 성공"),
    RESTAURANT_CATEGORY_CHANGE_SUCCESS("R002","카테고리 변경 성공"),
    GET_RESTAURANT_BY_CATEGORY_SUCCESS("R003", "특정 카테고리 레스토랑 조회 성공"),
    DELETE_RESTAURANT_SUCCESS("R004", "레스토랑 삭제 성공"),
    GET_FIND_BY_ID_RESTAURANT("R005", "레스토랑 조회 성공"),

    // 리뷰
    CREATE_REVIEW_SUCCESS("V001", "리뷰 생성 성공"),
    UPDATE_REVIEW_SUCCESS("VOO2","리뷰 수정 성공"),
    GET_REVIEW_SUCCESS("VOO3","리뷰 조회 성공"),
    DELETE_REVIEW_SUCCESS("V004", "리뷰 삭제 성공");



    private final String code;
    private final String message;
}
