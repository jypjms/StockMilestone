package fisa.stockmilestone.modules.account.repository;

import fisa.stockmilestone.modules.account.domain.Account;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AccountRepository extends JpaRepository<Account, Long> {
    @Override
    Optional<Account> findById(Long aLong);
}
