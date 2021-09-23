package com.onufrei.sn.service.authority.impl;

import com.onufrei.sn.dao.AuthorityDao;
import com.onufrei.sn.dto.AuthorityDto;
import com.onufrei.sn.dto.AuthorityInDto;
import com.onufrei.sn.service.authority.intf.AuthorityService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthorityServiceImpl implements AuthorityService {

	private final AuthorityDao authorityDao;

	public AuthorityServiceImpl(AuthorityDao authorityDao) {
		this.authorityDao = authorityDao;
	}

	@Override
	public Boolean add(AuthorityInDto authority) {
		return authorityDao.add(authority) > 0;
	}

	@Override
	public Boolean addToAccount(Long accountId, Long authorityId) {
		return authorityDao.addToAccount(accountId, authorityId) > 0;
	}

	@Override
	public Boolean update(AuthorityInDto authority) {
		return authorityDao.update(authority) > 0;
	}

	@Override
	public void delete(Long id) {
		authorityDao.delete(id);
	}

	@Override
	public AuthorityDto getById(Long id) {
		return authorityDao.getById(id);
	}

	@Override
	public List<AuthorityDto> getAll() {
		return authorityDao.getAll();
	}
}
