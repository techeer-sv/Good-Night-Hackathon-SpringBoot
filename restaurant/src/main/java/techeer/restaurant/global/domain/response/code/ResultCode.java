package techeer.restaurant.global.domain.response.code;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ResultCode {

    // restaurant
    CREATE_RESTAURANT_SUCCESS("R001", "레스토랑 생성 성공"),
    UPDATE_RESTAURANT_SUCCESS("R002", "레스토랑 수정 성공"),
    GET_ALL_RESTAURANT_SUCCESS("R003-1", "레스토랑 전체 조회 성공"),
    GET_CATEGORY_RESTAURANT_SUCCESS("R003-2", "레스토랑 카테고리 별 조회 성공"),
    GET_ONE_RESTAURANT_SUCCESS("R004", "레스토랑 단일 조회 성공"),
    DELETE_RESTAURANT_SUCCESS("R005", "레스토랑 삭제 성공"),

    //review
    GET_ALL_REVIEW_SUCCESS("RV001", "리뷰 전체 조회 성공"),
    GET_ONE_REVIEW_SUCCESS("RV002", "리뷰 단일 조회 성공"),
    UPDATE_REVIEW_SUCCESS("RV003", "리뷰 수정 성공"),
    CREATE_REVIEW_SUCCESS("RV004", "리뷰 생성 성공"),
    DELETE_REVIEW_SUCCESS("RV005", "리뷰 삭제 성공"),
    ;

    private final String code;
    private final String message;
}
