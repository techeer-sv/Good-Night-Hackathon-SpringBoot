package com.project.hackathon.global.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ResultResponse {

    // restaurant
    RESTAURANT_CREATE_SUCCESS("RT001", "레스토랑 등록 성공"),
    RESTAURANT_DELETE_SUCCESS("RT002", "레스토랑 삭제 성공"),
    RESTAURANT_UPDATE_SUCCESS("RT003", "레스토랑 수정 성공"),

    // review
    REVIEW_CREATE_SUCCESS("RV001", "리뷰 업로드 성공"),
    REVIEW_GET_SUCCESS("RV002", "리뷰 조회 성공"),
    REVIEW_DELETE_SUCCESS("RV003", "리뷰 삭제 성공"),
    REVIEW_LIST_PAGE_GET_SUCCESS("RV005", "리뷰 리스트 페이징 조회 성공"),
    REVIEW_LIST_PAGE_SEARCH_SUCCESS("RV006", "리뷰 검색 성공"),
    ;

    private final String code;
    private final String message;
}