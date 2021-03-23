package com.anz.ddtb.account;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.core.context.SecurityContextHolder;

@SpringBootApplication
public class AccountManagementApplication{

	public static void main(String[] args) {
		SecurityContextHolder.setStrategyName(SecurityContextHolder.MODE_INHERITABLETHREADLOCAL);
		try {
			SpringApplication.run(AccountManagementApplication.class, args);
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println(e);
			System.exit(-1);
		}
	}

}
