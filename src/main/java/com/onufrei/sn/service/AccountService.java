package com.onufrei.sn.service;

import com.onufrei.sn.dao.AccountDao;
import com.onufrei.sn.dto.AccountDto;
import com.onufrei.sn.dto.AccountInDto;
import org.springframework.stereotype.Service;
import org.apache.commons.codec.digest.DigestUtils;

@Service
public class AccountService {

	private final AccountDao accountDao;
	private final AuthorityService authorityService;

	public AccountService(AccountDao accountDao, AuthorityService authorityService) {
		this.accountDao = accountDao;
		this.authorityService = authorityService;
	}

	public Long add(AccountInDto account) {
		return accountDao.add(account);
	}

	public Boolean register(AccountInDto account) {
		AccountInDto accountWithHashedPassword = AccountInDto.builder()
				.username(account.getUsername())
				.password(DigestUtils.sha256Hex(account.getPassword()))
				.build();

		if (accountDao.getByUsername(account.getUsername()) == null && add(accountWithHashedPassword) != null) {
			authorityService.addToAccount(getByUsername(account.getUsername()).getId(), 2L);
			return true;
		}

		return false;
	}

	public Boolean update(Long accountId, AccountInDto account) {
		return accountDao.update(accountId, account) > 0;
	}

	public void delete(Long accountId) {
		accountDao.delete(accountId);
	}

	public AccountDto getByUsername(String username){
		return accountDao.getByUsername(username);
	}

	public Boolean exist(String username, String password){
		return accountDao.exist(username, password);
	}
}
