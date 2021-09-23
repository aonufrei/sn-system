package com.onufrei.sn.controller.rest;

import com.onufrei.sn.dto.AccountInDto;
import com.onufrei.sn.service.AccountService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/accounts")
public class AccountRestController {

	private final AccountService accountService;

	public AccountRestController(AccountService accountService) {
		this.accountService = accountService;
	}

	@PostMapping("/management")
	public Boolean register(@RequestBody AccountInDto account) {
		return accountService.register(account);
	}

	@PostMapping("/management/unregister")
	public void unregister() {
		//TODO: check if user is authorized, get id of user and delete it
	}

}
