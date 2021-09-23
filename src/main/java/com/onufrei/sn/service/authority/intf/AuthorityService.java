package com.onufrei.sn.service.authority.intf;

import com.onufrei.sn.dto.AuthorityDto;
import com.onufrei.sn.dto.AuthorityInDto;

import java.util.List;

public interface AuthorityService {

	Boolean add(AuthorityInDto authority);

	Boolean addToAccount(Long accountId, Long authorityId);

	Boolean update(AuthorityInDto authority);

	void delete(Long id);

	AuthorityDto getById(Long id);

	List<AuthorityDto> getAll();
}
