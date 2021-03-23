package com.anz.ddtb.account.dto;

import lombok.Data;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Data
public class TransactionDTO implements Serializable {

    @NotNull private String accountNumber;

    @NotNull private String accountName;

    private String valueDate;

    private String currency;

    private String debitAmount;

    private String creditAmount;

    private String debitCredit;

    private String transactionNarrative;

}