package az.bank.account.msaccount.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AccountDto implements Serializable {

    private Long id;
    private Long customerId;
    private String accountNo;
    private CurrencyEnum currency;
    private double amount;
    private boolean isDeleted;
    private Status status;
    private String customerName;
}
