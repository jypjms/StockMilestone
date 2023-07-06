package fisa.stockmilestone.modules.account.service;

import fisa.stockmilestone.infra.oauth.service.AuthService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class AuthServiceTest {

    @Autowired
    private AuthService authService;

    @Test
    void 구글_소셜_로그인_링크_생성하기(){
        String link = authService.generateGoogleLink();
        System.out.println(link);
    }
}