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
@Table(name = "accounts_history")
public class AccountHistoryEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private AccountEntity account;

    private Long customerId;
    private String accountNo;
    @Enumerated(EnumType.STRING)
    private CurrencyEnum currency;
    private double amount;
    private String note;
    private boolean isDeleted;
    @Enumerated(EnumType.STRING)
    private Status status;

    @CreationTimestamp
    @Column(nullable = false,updatable = false)
    private LocalDateTime createdAt;
    @UpdateTimestamp
    @Column(nullable = false)
    private LocalDateTime updatedAt;
}
