package techeer.restaurant.global.domain.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import techeer.restaurant.global.domain.response.code.ResultCode;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class ResultResponse {
    private String code;
    private String message;
    private Object data;

    public static ResultResponse of(ResultCode resultCode, Object data) {
        return new ResultResponse(resultCode, data);
    }

    public ResultResponse(ResultCode resultCode, Object data) {
        this.code = resultCode.getCode();
        this.message = resultCode.getMessage();
        this.data = data;
    }
}
