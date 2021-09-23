package com.onufrei.sn.service.impl;

import com.onufrei.sn.mapper.AccountMapper;
import com.onufrei.sn.model.Account;
import com.onufrei.sn.service.intf.AccountService;
import org.springframework.stereotype.Service;

@Service
public class AccountServiceImpl implements AccountService {

	private final AccountMapper mapper;

	public AccountServiceImpl(AccountMapper mapper) {
		this.mapper = mapper;
	}

	@Override
	public Boolean add(Account account) {
		return mapper.add(account) > 0;
	}

	@Override
	public Boolean update(Account account) {
		return mapper.update(account) > 0;
	}

	@Override
	public void delete(Long accountId) {
		mapper.delete(accountId);
	}

	@Override
	public Account getByUsername(String username){
		return mapper.getByUsername(username);
	}

	@Override
	public Boolean exist(String username, String password){
		return mapper.exist(username, password);
	}

	public static Account modelToDto(Account model) {
		return Account.builder()
				.id(model.getId())
				.username(model.getUsername())
				.password(model.getPassword())
				.createdAt(model.getCreatedAt())
				.modifiedAt(model.getModifiedAt())
				.build();
	}
}
