package fisa.stockmilestone.infra.oauth.dto;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
@RequiredArgsConstructor
@Getter
public class GoogleTokenResponse {
    private final String accessToken;
    private final String refreshToken;
    private final String idToken;
    private final String expiresIn;
    private final String tokenType;
    private final String scope;

}
