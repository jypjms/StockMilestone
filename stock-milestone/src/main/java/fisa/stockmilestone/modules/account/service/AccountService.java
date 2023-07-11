package fisa.stockmilestone.modules.account.service;

import fisa.stockmilestone.modules.account.domain.Account;
import fisa.stockmilestone.modules.account.repository.AccountRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AccountService {
    private final AccountRepository accountRepository;
    public boolean existsByEmail(String email) {
        return accountRepository.existsByEmail(email);
    }

    public void save(Account account) {
        accountRepository.save(account);
    }

    public Account findByEmail(String email) {
        return accountRepository.findByEmail(email);
    }
}
