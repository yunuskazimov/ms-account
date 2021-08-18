package az.bank.account.msaccount.service;

import az.bank.account.msaccount.client.CustomerClient;
import az.bank.account.msaccount.dao.AccountEntity;
import az.bank.account.msaccount.mapper.AccountMapper;
import az.bank.account.msaccount.mapper.MailMapper;
import az.bank.account.msaccount.model.AccountDto;
import az.bank.account.msaccount.model.client.CustomerApiDto;
import az.bank.account.msaccount.queue.AccountMailSender;
import az.bank.account.msaccount.repository.AccountRepository;
import az.bank.account.msaccount.util.AccountUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountServiceImpl implements AccountService {
    private final AccountRepository accountRepository;
    private final CustomerClient customerClient;
    private final AccountMailSender accountMailSender;
    private final AccountUtil accountUtil;
    private static final Logger logger = LoggerFactory.getLogger(AccountService.class);

    public AccountServiceImpl(AccountRepository accountRepository,
                              CustomerClient customerClient,
                              AccountMailSender accountMailSender,
                              AccountUtil accountUtil) {
        this.accountRepository = accountRepository;
        this.customerClient = customerClient;
        this.accountMailSender = accountMailSender;
        this.accountUtil = accountUtil;
    }

    @Override
    public AccountDto createAccount(AccountDto accountDto) {
        CustomerApiDto customerDto = customerClient
                .getCustomer(accountDto.getCustomerId());

        accountDto.setCustomerName(customerDto.getFirstName());

        AccountEntity entity = accountRepository.save(AccountMapper.dtoToEntity(accountDto));
        accountDto.setId(entity.getId());

        accountMailSender.sendMail(MailMapper.mailMapper("Acoount created",
                accountRepository.findByCustomerId(accountDto.getCustomerId()),
                customerDto
        ));

        return accountDto;
    }

    @Override
    public AccountDto editAccount(AccountDto dto) {
        accountUtil.findAccount(dto.getId());
        AccountEntity entity = AccountMapper.dtoToEntity(dto);
        entity.setId(dto.getId());
        accountRepository.save(entity);
        return dto;
    }


    @Override
    public AccountDto getAccount(Long Id) {
        AccountDto dto = AccountMapper.entityToDto(accountRepository.findById(Id).get());

        customerClient.getCustomer(dto.getCustomerId());
        return dto;
    }

    @Override
    public List<AccountDto> getAccounts() {
        return AccountMapper.entitiesToDtos(accountRepository.findAll());
    }

}
