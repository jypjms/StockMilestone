package fisa.stockmilestone.modules.account.service;

import fisa.stockmilestone.infra.oauth.client.GoogleOAuthClient;
import fisa.stockmilestone.infra.oauth.endpoint.GoogleOAuthEndPoint;
import fisa.stockmilestone.infra.oauth.support.JwtProvider;
import fisa.stockmilestone.modules.account.domain.Account;
import fisa.stockmilestone.modules.account.domain.SocialType;
import fisa.stockmilestone.modules.account.dto.OAuthAccount;
import fisa.stockmilestone.modules.account.dto.TokenResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class AuthService {

    private final GoogleOAuthEndPoint oAuthEndpoint;
    private final GoogleOAuthClient oAuthClient;
    private final AccountService memberService;
    private final JwtProvider jwtProvider;

    public String generateGoogleLink() {
        return oAuthEndpoint.generate();
    }

    @Transactional
    public TokenResponse generateTokenWithCode(final String code) {
        OAuthAccount oAuthAccount = oAuthClient.getOAuthMember(code);
        String email = oAuthAccount.getEmail();

        signUpAccountIfNotExists(oAuthAccount, email);

        Account foundAccount = memberService.findByEmail(email);
        String accessToken = jwtProvider.createToken(String.valueOf(foundAccount.getId()));

        return new TokenResponse(accessToken);
    }

    private void signUpAccountIfNotExists(final OAuthAccount oAuthAccount, final String email) {
        if (!memberService.existsByEmail(email)) {
            memberService.save(generateMemberBy(oAuthAccount));
        }
    }

    private Account generateMemberBy(final OAuthAccount oAuthAccount) {
        return Account.createAccount(oAuthAccount.getEmail(),oAuthAccount.getNickName(), SocialType.GOOGLE);
    }
}
