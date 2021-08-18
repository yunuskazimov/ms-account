package az.bank.account.msaccount.repository;

import az.bank.account.msaccount.dao.AccountEntity;
import az.bank.account.msaccount.dao.AccountHistoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AccountHistoryRepository extends JpaRepository<AccountHistoryEntity,Long> {
}
