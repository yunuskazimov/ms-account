package az.bank.account.msaccount.dao;

import az.bank.account.msaccount.model.CurrencyEnum;
import az.bank.account.msaccount.model.Status;
import az.bank.account.msaccount.shared.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "accounts")
@EntityListeners(AccountEntityListener.class)
public class AccountEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long customerId;
    private String accountNo;
    @Enumerated(EnumType.STRING)
    private CurrencyEnum currency;
    private double amount;
    private boolean isDeleted;
    @Enumerated(EnumType.STRING)
    private Status status;

    @CreationTimestamp
    @Column(nullable = false,updatable = false)
    private LocalDateTime createdAt;
    @UpdateTimestamp
    @Column(nullable = false)
    private LocalDateTime updatedAt;


    AccountHistoryEntity toAccountHistoryEntityAfterSave() {
        return AccountHistoryEntity.builder()
                .account(this)
                .accountNo(this.accountNo)
                .amount(this.amount)
                .customerId(this.customerId)
                .currency(this.currency)
                .note("Account Created")
                .isDeleted(this.isDeleted)
                .status(this.status)
                .build();
    }

    AccountHistoryEntity toAccountHistoryEntityAfterUpdate() {
        return AccountHistoryEntity.builder()
                .account(this)
                .accountNo(this.accountNo)
                .amount(this.amount)
                .customerId(this.customerId)
                .currency(this.currency)
                .note("Account Updated")
                .build();
    }
}
