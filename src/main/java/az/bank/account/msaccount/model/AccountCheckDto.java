package az.bank.account.msaccount.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AccountCheckDto {
    private Long id;
    private Long account_id;
    private Long customerId;
    private String accountNo;
    private CurrencyEnum currency;
    private double amount;
    private boolean isDeleted;
    private Status status;
    private String customerName;
    private String sequenceNumber;
}
