package fisa.stockmilestone.modules.account.repository;

import fisa.stockmilestone.modules.account.domain.Account;
import fisa.stockmilestone.modules.account.domain.UserStatus;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class AccountRepositoryTest {

    @Autowired
    private AccountRepository accountRepository;

    @Test
    void 중복_이메일_검사_기능(){
        String email = "kjiny@google.com";
        Account account1 = Account.builder().email(email).commentNum(0).postNum(0)
                .nickName("test1").status(UserStatus.ACTIVE).build();
        accountRepository.save(account1);

        boolean result = accountRepository.existsByEmail(email);

        Assertions.assertThat(result).isTrue();
    }
}