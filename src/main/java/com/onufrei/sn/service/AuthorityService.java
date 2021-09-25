package com.onufrei.sn.service;

import com.onufrei.sn.dao.AuthorityDao;
import com.onufrei.sn.dto.AuthorityDto;
import com.onufrei.sn.dto.AuthorityInDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthorityService {

	private final AuthorityDao authorityDao;

	public AuthorityService(AuthorityDao authorityDao) {
		this.authorityDao = authorityDao;
	}

	public Long add(AuthorityInDto authority) {
		return authorityDao.add(authority);
	}

	public Boolean addToAccount(Long accountId, Long authorityId) {
		return authorityDao.addToAccount(accountId, authorityId) > 0;
	}

	public Boolean update(Long authorityId, AuthorityInDto authority) {
		return authorityDao.update(authorityId, authority) > 0;
	}

	public void delete(Long id) {
		authorityDao.delete(id);
	}

	public AuthorityDto getById(Long id) {
		return authorityDao.getById(id);
	}

	public List<AuthorityDto> getAll() {
		return authorityDao.getAll();
	}
}
