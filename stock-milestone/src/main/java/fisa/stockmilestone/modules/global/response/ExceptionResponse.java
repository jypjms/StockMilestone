package fisa.stockmilestone.modules.global.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
@AllArgsConstructor
@JsonPropertyOrder({"isSuccess", "code", "message"})
public class ExceptionResponse {
    @JsonProperty("isSuccess")
    private final Boolean isSuccess;
    private final String message;
    private final int code;

    // 요청에 실패한 경우
    public ExceptionResponse(BaseResponseStatus status){
        this.isSuccess = status.isSuccess();
        this.message = status.getMessage();
        this.code = status.getCode();
    }

    public ExceptionResponse(int code, String message){
        this.isSuccess = false;
        this.message = message;
        this.code = code;
    }
}
