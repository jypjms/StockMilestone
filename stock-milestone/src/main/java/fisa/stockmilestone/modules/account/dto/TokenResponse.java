package fisa.stockmilestone.modules.account.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@NoArgsConstructor
public class TokenResponse {
    private String accessToken;
    public TokenResponse(String accessToken) {
        this.accessToken = accessToken;
    }
}
