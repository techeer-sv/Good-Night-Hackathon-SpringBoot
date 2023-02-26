package com.techeer.hackathon.global.result;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ResultCode {

    RESTAURANT_CREATE_SUCCESS("R001", "레스토랑 생성 성공"),
    CHANGE_CATEGORY_SUCCESS("R002", "카테고리 변경 성공"),
    GET_ALL_RESTAURANTS_SUCCESS("R003", "전체 카테고리 조회 성공"),
    DELETE_RESTAURANTS_SUCCESS("R004", "레스토랑 삭제 성공"),
    GET_RESTAURANTS_SUCCESS("R005", "카테고리 조회 성공"),

    REVIEW_CREATE_SUCCESS("V001", "리뷰 등록 성공"),
    GET_REVIEW_SUCCESS("V002", "리뷰 조회 성공"),
    DELETE_REVIEW_SUCCESS("V003", "리뷰 삭제 성공"),
    UPDATE_REVIEW_SUCCESS("V004", "리뷰 수정 성공");

    private final String code;
    private final String message;
}
