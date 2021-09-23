package com.onufrei.sn.utils;

import com.onufrei.sn.dto.AccountDto;
import com.onufrei.sn.dto.AccountInDto;
import com.onufrei.sn.model.Account;

public class AccountUtils {

	public static AccountDto toDto(Account account) {
		if (account == null) return null;

		return AccountDto.builder()
				.id(account.getId())
				.username(account.getUsername())
				.password(account.getPassword())
				.createdAt(account.getCreatedAt())
				.modifiedAt(account.getModifiedAt())
				.build();
	}

	public static Account toModel(AccountInDto account) {
		if (account == null) return null;

		return Account.builder()
				.username(account.getUsername())
				.password(account.getPassword())
				.build();
	}

}
