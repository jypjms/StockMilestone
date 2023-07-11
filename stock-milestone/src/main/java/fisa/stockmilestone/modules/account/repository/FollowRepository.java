package fisa.stockmilestone.modules.account.repository;

import fisa.stockmilestone.modules.account.domain.Follow;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FollowRepository extends JpaRepository<Follow, Long> {
}
