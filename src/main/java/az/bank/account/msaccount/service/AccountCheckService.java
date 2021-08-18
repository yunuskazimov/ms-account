package az.bank.account.msaccount.service;

import az.bank.account.msaccount.model.AccountCheckDto;

import java.util.List;

public interface AccountCheckService {
    AccountCheckDto createAccount(AccountCheckDto dto);
    AccountCheckDto getAccount();

    List<AccountCheckDto> getAccounts();

    List<AccountCheckDto> getBySequenceNumber(String seq);
}
