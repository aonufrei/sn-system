package com.onufrei.sn.service.account.intf;

import com.onufrei.sn.dto.AccountDto;
import com.onufrei.sn.dto.AccountInDto;

public interface AccountService {

	Boolean add(AccountInDto account);

	Boolean update(AccountInDto account);

	void delete(Long accountId);

	AccountDto getByUsername(String username);

	Boolean exist(String username, String password);

}
