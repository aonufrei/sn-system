package com.onufrei.sn.service.intf;

import com.onufrei.sn.model.Account;

public interface AccountService {

	Boolean add(Account account);

	Boolean update(Account account);

	void delete(Long accountId);

	Account getByUsername(String username);

	Boolean exist(String username, String password);

}
