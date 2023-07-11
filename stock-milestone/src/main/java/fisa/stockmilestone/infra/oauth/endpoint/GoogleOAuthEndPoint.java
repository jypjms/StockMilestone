package fisa.stockmilestone.infra.oauth.endpoint;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class GoogleOAuthEndPoint {
    private static final String GOOGLE_OAUTH_END_POINT = "https://accounts.google.com/o/oauth2/v2/auth";
    private final String googleRedirectUri;
    private final String googleClientId;
    private final List<String> scopes;

    public GoogleOAuthEndPoint(@Value("${oauth.google.redirect-uri}") final String googleRedirectUri,
                               @Value("${oauth.google.client-id}") final String googleClientId,
                               @Value("${oauth.google.scopes}") final List<String> scopes) {
        this.googleRedirectUri = googleRedirectUri;
        this.googleClientId = googleClientId;
        this.scopes = scopes;
    }

    public String generate() {
        return GOOGLE_OAUTH_END_POINT + "?"
                + "client_id=" + googleClientId + "&"
                + "redirect_uri=" + googleRedirectUri + "&"
                + "response_type=code&"
                + "scope="+ scopes.get(0) +" "+ scopes.get(1);
    }
}
