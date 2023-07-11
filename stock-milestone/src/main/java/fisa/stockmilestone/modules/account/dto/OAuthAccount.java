package fisa.stockmilestone.modules.account.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public class OAuthAccount {
    private final String email;
    private final String nickName;
}
