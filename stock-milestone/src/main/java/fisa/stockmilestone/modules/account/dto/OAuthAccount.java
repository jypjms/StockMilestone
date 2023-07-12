package fisa.stockmilestone.modules.account.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class OAuthAccount {
    private String email;
    private String nickName;
}
