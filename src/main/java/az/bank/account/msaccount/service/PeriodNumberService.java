package az.bank.account.msaccount.service;

import az.bank.account.msaccount.model.PeriodNumberDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface PeriodNumberService {
    PeriodNumberDto createAccount (PeriodNumberDto periodNumberDto);
    PeriodNumberDto getAccount (Long Id);
    List<PeriodNumberDto> getAccounts();
}
