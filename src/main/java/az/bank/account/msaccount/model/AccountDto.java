package az.bank.account.msaccount.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel("Account Data")
public class AccountDto implements Serializable {

    @ApiModelProperty("Unique id of account. Not used in post requests.")
    private Long id;

    @ApiModelProperty(value = "Enter valid customer ID",example = "1")
    private Long customerId;

    @ApiModelProperty(value = "Name of account",example = "ABC444")
    private String accountNo;

    @ApiModelProperty(value = "Currency of account. EX: USD, AZN, EUR...",example = "AZN")
    private CurrencyEnum currency;

    @ApiModelProperty(value = "Amount of account",example = "444.44")
    private double amount;

    @ApiModelProperty(value = "Account deletion status",example = "false")
    private boolean isDeleted;

    @ApiModelProperty(value = "Account status",example = "PENDING")
    private Status status;

    @ApiModelProperty(value = "Customer name of account. Not used in post requests.",example = "Yunus")
    private String customerName;
}
