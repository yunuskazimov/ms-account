package az.bank.account.msaccount.util;

import az.bank.account.msaccount.dao.AccountEntity;
import az.bank.account.msaccount.model.exception.AccountNotFoundExcep;
import az.bank.account.msaccount.repository.AccountRepository;
import org.springframework.stereotype.Component;

@Component
public class AccountUtil {
    private final AccountRepository accountRepository;


    public AccountUtil(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    public AccountEntity findAccount(Long id) {
        return accountRepository.findById(id)
                .orElseThrow(() -> new AccountNotFoundExcep("Account Not Found By This ID."));
    }



}
