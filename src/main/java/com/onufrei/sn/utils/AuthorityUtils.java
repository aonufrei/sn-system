package com.onufrei.sn.utils;

import com.onufrei.sn.dto.AuthorityDto;
import com.onufrei.sn.dto.AuthorityInDto;
import com.onufrei.sn.model.Authority;

public class AuthorityUtils {

	public static AuthorityDto toDto(Authority authority) {
		if (authority == null) return null;

		return AuthorityDto.builder()
				.id(authority.getId())
				.name(authority.getName())
				.build();
	}

	public static Authority toModel(AuthorityInDto authority) {
		if (authority == null) return null;

		return Authority.builder()
				.name(authority.getName())
				.build();
	}
}
