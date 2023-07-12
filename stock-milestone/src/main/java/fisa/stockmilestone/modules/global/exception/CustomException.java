package fisa.stockmilestone.modules.global.exception;

import fisa.stockmilestone.modules.global.response.ResponseStatusCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CustomException extends RuntimeException{
    private ResponseStatusCode status;

    private CustomException(){}

    public CustomException(final ResponseStatusCode status){
        this.status = status;
    }
}
