package fisa.stockmilestone.config;

import fisa.stockmilestone.modules.account.domain.Account;
import fisa.stockmilestone.modules.account.domain.UserStatus;
import fisa.stockmilestone.modules.account.repository.AccountRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.PostConstruct;

/*
 * create 모드로 개발 시 기본데이터 초기화 기능
 */
@Component
@RequiredArgsConstructor
public class InitDb {
    private final InitService initService;

    @PostConstruct
    public void init(){
        initService.dbInit1();
    }

    @Component
    @Transactional
    @RequiredArgsConstructor
    static class InitService{
        private final AccountRepository accountRepository;

        public void dbInit1(){
            Account account1 = Account.builder().email("abc@abc.com").commentNum(0).postNum(0)
                    .nickName("jiny").status(UserStatus.ACTIVE).build();
            accountRepository.save(account1);

            Account account2 = Account.builder().email("abc2@abc.com").commentNum(0).postNum(0)
                    .nickName("mindyo").status(UserStatus.ACTIVE).build();
            accountRepository.save(account2);
        }
    }

}
