package az.bank.account.msaccount.mapper;

import az.bank.account.msaccount.dao.AccountEntity;
import az.bank.account.msaccount.model.MailDto;
import az.bank.account.msaccount.model.client.CustomerApiDto;

import java.util.List;

public class MailMapper {

    public static MailDto mailMapper(String text,
                                     List<AccountEntity> accountEntities,
                                     CustomerApiDto customerDto){
        return MailDto.builder()
                .text(text)
                .accountDtos(AccountMapper.entitiesToDtos(accountEntities))
                .customerDto(customerDto)
                .build();
    }
}
