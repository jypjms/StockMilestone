package fisa.stockmilestone.modules.account.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

@Getter
public class TokenRequest {
    private String code;

    private TokenRequest(){

    }
    public TokenRequest(final String code){
        this.code = code;
    }
}
