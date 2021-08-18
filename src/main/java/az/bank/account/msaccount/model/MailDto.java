package az.bank.account.msaccount.model;

import az.bank.account.msaccount.model.client.CustomerApiDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.context.annotation.Configuration;

import java.io.Serializable;
import java.util.List;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Configuration
public class MailDto implements Serializable {
    private String text;
    private List<AccountDto> accountDtos;
    private CustomerApiDto customerDto;
}
