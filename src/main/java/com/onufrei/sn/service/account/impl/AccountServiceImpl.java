package com.onufrei.sn.service.account.impl;

import com.onufrei.sn.dao.AccountDao;
import com.onufrei.sn.dto.AccountDto;
import com.onufrei.sn.dto.AccountInDto;
import com.onufrei.sn.service.account.intf.AccountService;
import org.springframework.stereotype.Service;

@Service
public class AccountServiceImpl implements AccountService {

	private final AccountDao accountDao;

	public AccountServiceImpl(AccountDao accountDao) {
		this.accountDao = accountDao;
	}

	@Override
	public Boolean add(AccountInDto account) {
		return accountDao.add(account) > 0;
	}

	@Override
	public Boolean update(AccountInDto account) {
		return accountDao.update(account) > 0;
	}

	@Override
	public void delete(Long accountId) {
		accountDao.delete(accountId);
	}

	@Override
	public AccountDto getByUsername(String username){
		return accountDao.getByUsername(username);
	}

	@Override
	public Boolean exist(String username, String password){
		return accountDao.exist(username, password);
	}
}
