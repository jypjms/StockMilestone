package fisa.stockmilestone.modules.global.exception.controller;

import fisa.stockmilestone.modules.global.exception.CustomException;
import fisa.stockmilestone.modules.global.response.BaseResponse;
import fisa.stockmilestone.modules.global.response.ResponseStatusCode;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ControllerAdvice {

    @ExceptionHandler(CustomException.class)
    public BaseResponse<ResponseStatusCode> exceptionHandle(CustomException ex){
        ExceptionResponse exceptionResponse = new ExceptionResponse(ex.getStatus());
        return exceptionResponse;
    }
}
