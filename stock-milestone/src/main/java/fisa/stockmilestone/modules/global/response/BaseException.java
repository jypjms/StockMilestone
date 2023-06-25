package fisa.stockmilestone.modules.global.response;

import fisa.stockmilestone.modules.global.response.BaseResponse;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class BaseException extends Exception{
    private BaseResponse status;
}
