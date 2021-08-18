package az.bank.account.msaccount.service;

import az.bank.account.msaccount.model.PeriodNumberDto;
import az.bank.account.msaccount.repository.PeriodNumberRepository;

import java.time.LocalDateTime;
import java.util.List;

public class PeriodNumberServiceImpl implements PeriodNumberService {
    private final PeriodNumberRepository periodNumberRepository;

    public PeriodNumberServiceImpl(PeriodNumberRepository periodNumberRepository) {
        this.periodNumberRepository = periodNumberRepository;
    }

    @Override
    public PeriodNumberDto createAccount(PeriodNumberDto periodNumberDto) {
String seqNumber = "SN"+ LocalDateTime.now();
        return null;
    }

    @Override
    public PeriodNumberDto getAccount(Long Id) {

        return null;
    }

    @Override
    public List<PeriodNumberDto> getAccounts() {
        return PeriodNumberMapper.entitiesToDtos(periodNumberRepository.findAll());
    }
}
