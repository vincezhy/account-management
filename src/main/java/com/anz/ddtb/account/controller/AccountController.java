package com.anz.ddtb.account.controller;

import java.util.List;

import com.anz.ddtb.account.dto.AccountDTO;
import com.anz.ddtb.account.dto.TransactionDTO;
import com.anz.ddtb.account.service.AccountService;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/accounts")
public class AccountController {

	@Autowired
	private AccountService accountService;

	@ApiOperation(value = "Retrieve All Accounts", response = List.class)
	@GetMapping
	public ResponseEntity<List<AccountDTO>> getAccountList() {
		List<AccountDTO> accountDtoList = accountService.getAccountList();
		log.info("Get Account List : {}", accountDtoList);
		return ResponseEntity.status(HttpStatus.OK).body(accountDtoList);
	}

}