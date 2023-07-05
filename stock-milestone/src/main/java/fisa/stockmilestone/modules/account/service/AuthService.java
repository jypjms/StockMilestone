package fisa.stockmilestone.modules.account.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@ConfigurationProperties(prefix = "oauth.google")
public class AuthService {
    private static final String GOOGLE_OAUTH_END_POINT = "https://accounts.google.com/o/oauth2/v2/auth";

    private final String googleRedirectUri;
    private final String googleClientId;
    private final String googleClientSecret;
    private final List<String> scopes;

    public AuthService(@Value("${oauth.google.redirect-uri}") final String googleRedirectUri,
                       @Value("${oauth.google.client-id}") final String googleClientId,
                       @Value("${oauth.google.client-secret}") final String googleClientSecret,
                       @Value("${oauth.google.scopes}") final List<String> scopes) {
        this.googleRedirectUri = googleRedirectUri;
        this.googleClientId = googleClientId;
        this.googleClientSecret = googleClientSecret;
        this.scopes = scopes;
    }

    public String generateGoogleLink() {
        return GOOGLE_OAUTH_END_POINT + "?"
                + "client_id=" + googleClientId + "&"
                + "redirect_uri=" + googleRedirectUri + "&"
                + "response_type=code&"
                + "scope="+ scopes.get(0) +" "+ scopes.get(1);
                //+ "scope=https://www.googleapis.com/auth/userinfo.profile https://www.googleapis.com/auth/userinfo.email";
    }
}
