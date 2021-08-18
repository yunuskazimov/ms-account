package az.bank.account.msaccount.service;

import az.bank.account.msaccount.model.AccountDto;

import java.util.List;

public interface AccountService {
    AccountDto createAccount (AccountDto accountDto);
    AccountDto editAccount (AccountDto dto);
    AccountDto getAccount (Long Id);
    List<AccountDto> getAccounts();
}
