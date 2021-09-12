package com.onufrei.sn.service.intf;

import com.onufrei.sn.dto.AccountDto;
import com.onufrei.sn.model.Account;

public interface AccountService {

	Boolean add(AccountDto account);

	Boolean update(AccountDto account);

	void delete(Long accountId);

	AccountDto getByUsername(String username);

	Boolean exist(String username, String password);

}
