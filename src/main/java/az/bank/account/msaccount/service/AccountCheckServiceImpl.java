package az.bank.account.msaccount.service;

import az.bank.account.msaccount.dao.AccountCheckEntity;
import az.bank.account.msaccount.mapper.AccountCheckMapper;
import az.bank.account.msaccount.model.AccountCheckDto;
import az.bank.account.msaccount.repository.AccountCheckRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class AccountCheckServiceImpl implements AccountCheckService {
    private final AccountCheckRepository accountCheckRepository;

    public AccountCheckServiceImpl(AccountCheckRepository accountCheckRepository) {
        this.accountCheckRepository = accountCheckRepository;
    }

    @Override
    public AccountCheckDto createAccount(AccountCheckDto dto) {
        AccountCheckEntity entity =
                accountCheckRepository.save(
                        AccountCheckMapper.dtoToEntity(dto));
        dto.setId(entity.getId());
        return dto;
    }

    @Override
    public AccountCheckDto getAccount() {
        return AccountCheckMapper.entityToDto(
                accountCheckRepository.findTopByOrderByIdDesc());
    }

    @Override
    public List<AccountCheckDto> getAccounts() {
        return AccountCheckMapper.entitiesToDtos(
                accountCheckRepository.findAll());
    }
    @Override
    public List<AccountCheckDto> getBySequenceNumber(String seq){

        return AccountCheckMapper.entitiesToDtos(
                accountCheckRepository.findBySequenceNumber(seq));
    }
}
