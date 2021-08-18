package az.bank.account.msaccount.repository;

import az.bank.account.msaccount.dao.AccountEntity;
import az.bank.account.msaccount.dao.AccountCheckEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AccountCheckRepository extends JpaRepository<AccountCheckEntity,Long> {

    AccountCheckEntity findTopByOrderByIdDesc();

    List<AccountCheckEntity> findBySequenceNumber (String seqNumber);
}
