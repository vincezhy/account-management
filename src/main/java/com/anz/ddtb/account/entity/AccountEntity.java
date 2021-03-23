package com.anz.ddtb.account.entity;

import com.anz.ddtb.account.common.AccountType;
import com.anz.ddtb.account.common.Currency;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import org.hibernate.annotations.DynamicUpdate;
import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

import static com.anz.ddtb.account.common.Constants.*;

@Entity
@Data
@Table(name = ACCOUNT_TABLE)
@AllArgsConstructor
@ToString
@NoArgsConstructor
@DynamicUpdate
public class AccountEntity extends SuperEntity {

	@Id
	@Column(name = ACCOUNT_NUMBER, unique = true, nullable = false)
	private String accountNumber;

	@Column(name = ACCOUNT_NAME)
	private String accountName;

	@Column(name = ACCOUNT_TYPE)
	@Enumerated(value = EnumType.STRING)
	private AccountType accountType;

	@Column(name = BALANCE_DATE)
	private LocalDate balanceDate;

	@Column(name = CURRENCY)
	@Enumerated(value = EnumType.STRING)
	private Currency currency;

	@Column(name = OPENING_AVAIlABLE_BALANCE)
	private BigDecimal openingAvailableBalance;

	@JsonIgnore
	@EqualsAndHashCode.Exclude
	@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, mappedBy = "accountEntity", fetch = FetchType.LAZY)
	private List<TransactionEntity> transactionEntityList;

}
