package fisa.stockmilestone.modules.global;

import fisa.stockmilestone.modules.board.exception.NoSuchPostException;
import fisa.stockmilestone.modules.global.response.BaseResponse;
import fisa.stockmilestone.modules.global.response.BaseResponseStatus;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ControllerAdvice {

    @ExceptionHandler({
            NoSuchPostException.class
    })
    public BaseResponse handleNoSuchData(final RuntimeException e){

        BaseResponse errorResponse = new BaseResponse(BaseResponseStatus.POST_NOT_FOUND);

        return errorResponse;
    }
}
