package techeer.restaurant.global.response.code;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ResultCode {

    RESTAURANT_CREATE_SUCCESS("R001", "레스토랑 생성 성공"),
    ;

    private final String code;
    private final String message;
}
