package com.anz.ddtb.account.dto;

import lombok.Data;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Data
public class AccountDTO implements Serializable{

    @NotNull private String accountNumber;

    @NotNull private String accountName;

    @NotNull private String accountType;

    private String balanceDate;

    private String currency;

    private String openingAvailableBalance;
}
