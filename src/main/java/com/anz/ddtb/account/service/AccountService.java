package com.anz.ddtb.account.service;

import com.anz.ddtb.account.dto.AccountDTO;
import com.anz.ddtb.account.dto.TransactionDTO;
import com.anz.ddtb.account.dto.mapper.AccountMapper;
import com.anz.ddtb.account.dto.mapper.TransactionMapper;
import com.anz.ddtb.account.entity.AccountEntity;
import com.anz.ddtb.account.repository.AccountRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountService {

    private final AccountRepository accountRepository;
    private final AccountMapper accountMapper;
    private final TransactionMapper transactionMapper;

    public AccountService(AccountRepository accountRepository, AccountMapper accountMapper, TransactionMapper transactionMapper){
        this.accountRepository = accountRepository;
        this.accountMapper = accountMapper;
        this.transactionMapper = transactionMapper;
    }

    public List<AccountDTO> getAccountList(){
        return accountMapper.entityListToDtoList(this.accountRepository.findAll());
    }

    public List<TransactionDTO> getTransactionList(String accountNumber){
        AccountEntity acct = this.accountRepository.findByAccountNumber(accountNumber);
        List<TransactionDTO> transactionList = transactionMapper.entityListToDtoList(acct.getTransactionEntityList(),
                acct.getAccountNumber(), acct.getAccountName(), acct.getCurrency().name());
        return transactionList;
    }

}
