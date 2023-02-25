package techeer.restaurant.global.domain.response.code;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ResultCode {

    RESTAURANT_CREATE_SUCCESS("R001", "레스토랑 생성 성공"),
    GET_ALL_RESTAURANT_SUCCESS("R003", "레스토랑 전체 조회 성공"),
    GET_ONE_RESTAURANT_SUCCESS("R004", "레스토랑 단일 조회 성공"),
    DELETE_RESTAURANT_SUCCESS("R005", "레스토랑 삭제 성공"),
    ;

    private final String code;
    private final String message;
}
