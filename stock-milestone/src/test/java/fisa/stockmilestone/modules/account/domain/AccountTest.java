package fisa.stockmilestone.modules.account.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AccountTest {

    @Test
    void 회원_생성_테스트(){
        String email = "abc@abc.com";
        String nickName = "박진영";
        SocialType socialType = SocialType.GOOGLE;

        Account account = Account.createAccount(email,nickName,socialType);

        Assertions.assertThat(account.getEmail()).isEqualTo(email);
        Assertions.assertThat(account.getNickName()).isEqualTo(nickName);
        Assertions.assertThat(account.getSocialType()).isEqualTo(socialType);

    }

}