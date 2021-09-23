package com.onufrei.sn.dao;

import com.onufrei.sn.dto.AuthorityDto;
import com.onufrei.sn.dto.AuthorityInDto;
import com.onufrei.sn.mapper.AuthorityMapper;
import com.onufrei.sn.utils.AuthorityUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AuthorityDao {

	private final AuthorityMapper authorityMapper;

	public AuthorityDao(AuthorityMapper authorityMapper) {
		this.authorityMapper = authorityMapper;
	}

	public int add(AuthorityInDto authority) {
		return authorityMapper.add(AuthorityUtils.toModel(authority));
	}

	public int addToAccount(Long accountId, Long authorityId) {
		return authorityMapper.addToAccount(accountId, authorityId);
	}

	public int update(AuthorityInDto authority) {
		return authorityMapper.update(AuthorityUtils.toModel(authority));
	}

	public void delete(Long id) {
		authorityMapper.delete(id);
	}

	public AuthorityDto getById(Long id) {
		return AuthorityUtils.toDto(authorityMapper.getById(id));
	}

	public List<AuthorityDto> getAll() {
		return authorityMapper.getAll().stream().map(AuthorityUtils::toDto).collect(Collectors.toList());
	}

}
