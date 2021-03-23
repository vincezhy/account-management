package com.anz.ddtb.account.entity;

import com.anz.ddtb.account.common.DebitCredit;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;

import static com.anz.ddtb.account.common.Constants.*;

@Entity
@Data
@Table(name = TRANSACTION_TABLE)
@AllArgsConstructor
@ToString
@NoArgsConstructor
@DynamicUpdate
public class TransactionEntity extends SuperEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = ID)
	private Long id;

	@JsonIgnore
	@ToString.Exclude
	@JoinColumn(name = ACCOUNT_NUMBER)
	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private AccountEntity accountEntity;

	@Column(name = VALUE_DATE)
	private LocalDate valueDate;

	@Column(name = DEBIT_AMOUNT)
	private BigDecimal debitAmount;

	@Column(name = CREDIT_AMOUNT)
	private BigDecimal creditAmount;

	@Column(name = DEBIT_CREDIT)
	@Enumerated(value = EnumType.STRING)
	private DebitCredit debitCredit;

	@Column(name = TRANSACTION_NARRATIVE)
	private String transactionNarrative;

}
