package com.onufrei.sn.dao;

import com.onufrei.sn.dto.AccountDto;
import com.onufrei.sn.dto.AccountInDto;
import com.onufrei.sn.mapper.AccountMapper;
import com.onufrei.sn.model.Account;
import com.onufrei.sn.utils.AccountUtils;
import org.springframework.stereotype.Service;

@Service
public class AccountDao {

	private final AccountMapper accountMapper;

	public AccountDao(AccountMapper accountMapper) {
		this.accountMapper = accountMapper;
	}

	public Long add(AccountInDto accountInDto) {
		Account accountToInsert = AccountUtils.toModel(accountInDto);
		accountMapper.add(accountToInsert);
		return accountToInsert.getId();
	}

	public int update(Long id, AccountInDto account) {
		return accountMapper.update(id, AccountUtils.toModel(account));
	}

	public void delete(Long accountId) {
		accountMapper.delete(accountId);
	}

	public AccountDto getByUsername(String username) {
		return AccountUtils.toDto(accountMapper.getByUsername(username));
	}

	public Boolean exist(String username, String password) {
		return accountMapper.exist(username, password);
	}

}
