package az.bank.account.msaccount.dao;

import az.bank.account.msaccount.repository.AccountHistoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.persistence.PostPersist;
import javax.persistence.PostUpdate;

@Component
public class AccountEntityListener {
    private static AccountHistoryRepository accountHistoryRepository;

    @Autowired
    public void init(AccountHistoryRepository accountHistoryRepository) {
        AccountEntityListener.accountHistoryRepository = accountHistoryRepository;
    }


    @PostPersist
    public void savedToAccountHistory(AccountEntity accountEntity) {
        accountHistoryRepository.save(accountEntity.toAccountHistoryEntityAfterSave());
    }
    @PostUpdate
    public void updatedToAccountHistory(AccountEntity accountEntity){
        accountHistoryRepository.save(accountEntity.toAccountHistoryEntityAfterUpdate());
    }



}
