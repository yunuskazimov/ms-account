package az.bank.account.msaccount.mapper;

import az.bank.account.msaccount.dao.AccountCheckEntity;
import az.bank.account.msaccount.model.AccountCheckDto;
import az.bank.account.msaccount.model.AccountDto;

import java.util.List;
import java.util.stream.Collectors;

public class AccountCheckMapper {
    public static AccountCheckEntity dtoToEntity(AccountCheckDto dto) {
        AccountCheckEntity entity = new AccountCheckEntity();
        entity.setSequenceNumber(dto.getSequenceNumber());
        entity.setAccount_id(dto.getAccount_id());
        entity.setCustomerId(dto.getCustomerId());
        entity.setAccountNo(dto.getAccountNo());
        entity.setAmount(dto.getAmount());
        entity.setCurrency(dto.getCurrency());
        entity.setDeleted(dto.isDeleted());
        entity.setStatus(dto.getStatus());
        return entity;
    }

    public static List<AccountCheckDto> entitiesToDtos(List<AccountCheckEntity> accountEntities) {
        return accountEntities
                .stream()
                .map(AccountCheckMapper::entityToDto)
                .collect(Collectors.toList());
    }

    public static AccountCheckDto entityToDto(AccountCheckEntity entity) {
        AccountCheckDto dto = new AccountCheckDto();
        dto.setSequenceNumber(entity.getSequenceNumber());
        dto.setAccount_id(entity.getAccount_id());
        dto.setId(entity.getId());
        dto.setCustomerId(entity.getCustomerId());
        dto.setAccountNo(entity.getAccountNo());
        dto.setAmount(entity.getAmount());
        dto.setStatus(entity.getStatus());
        dto.setCurrency(entity.getCurrency());
        dto.setDeleted(entity.isDeleted());

        return dto;
    }

    public static AccountCheckDto accountToCheck(AccountDto accountDto, String seqNumber) {
        AccountCheckDto checkDto = new AccountCheckDto();
        checkDto.setSequenceNumber(seqNumber);
        checkDto.setAccount_id(accountDto.getId());
        checkDto.setAccountNo(accountDto.getAccountNo());
        checkDto.setAmount(accountDto.getAmount());
        checkDto.setCurrency(accountDto.getCurrency());
        checkDto.setId(accountDto.getId());
        checkDto.setDeleted(accountDto.isDeleted());
        checkDto.setCustomerId(accountDto.getCustomerId());
        checkDto.setStatus(accountDto.getStatus());
        checkDto.setCustomerName(accountDto.getCustomerName());
        return checkDto;
    }
}
