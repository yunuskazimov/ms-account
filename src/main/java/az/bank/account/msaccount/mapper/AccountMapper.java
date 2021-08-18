package az.bank.account.msaccount.mapper;

import az.bank.account.msaccount.dao.AccountEntity;
import az.bank.account.msaccount.model.AccountDto;

import java.util.List;
import java.util.stream.Collectors;

public class AccountMapper {

    public static AccountEntity dtoToEntity(AccountDto dto) {
        AccountEntity entity = new AccountEntity();

        entity.setCustomerId(dto.getCustomerId());
        entity.setAccountNo(dto.getAccountNo());
        entity.setAmount(dto.getAmount());
        entity.setCurrency(dto.getCurrency());
        entity.setDeleted(dto.isDeleted());
        entity.setStatus(dto.getStatus());
        return entity;
    }

    public static List<AccountDto> entitiesToDtos(List<AccountEntity> accountEntities) {
        return accountEntities
                .stream()
                .map(AccountMapper::entityToDto)
                .collect(Collectors.toList());
    }

    public static AccountDto entityToDto(AccountEntity entity) {
        AccountDto dto = new AccountDto();
        dto.setId(entity.getId());
        dto.setCustomerId(entity.getCustomerId());
        dto.setAccountNo(entity.getAccountNo());
        dto.setAmount(entity.getAmount());
        dto.setStatus(entity.getStatus());
        dto.setCurrency(entity.getCurrency());
        dto.setDeleted(entity.isDeleted());
        return dto;
    }

}
