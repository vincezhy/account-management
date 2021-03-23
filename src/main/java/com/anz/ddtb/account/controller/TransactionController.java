package com.anz.ddtb.account.controller;

import com.anz.ddtb.account.dto.AccountDTO;
import com.anz.ddtb.account.dto.TransactionDTO;
import com.anz.ddtb.account.service.AccountService;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/transactions")
public class TransactionController {

	private AccountService accountService;

	public TransactionController(AccountService accountService){
		this.accountService = accountService;
	}

	@ApiOperation(value = "Retrieve All transactions associated with an account", response = List.class)
	@GetMapping
	public ResponseEntity<List<TransactionDTO>> getTransactionList(@RequestParam String accountNumber) {
		List<TransactionDTO> transactionList = accountService.getTransactionList(accountNumber);
		log.info("Get Transactions : {} , by accountNumber : {}", transactionList, accountNumber);
		return ResponseEntity.status(HttpStatus.OK).body(transactionList);
	}

}
