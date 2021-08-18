package az.bank.account.msaccount.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PeriodNumberRepository extends JpaRepository<PeriodNumberEntitiy,Long> {
}
