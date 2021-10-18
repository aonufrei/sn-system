package com.onufrei.sn.constants;

public enum Roles {
	ROLE_ADMIN("ROLE_ADMIN", 1L),
	ROLE_USER("ROLE_ADMIN", 2L);

	private final String value;
	private final Long id;

	Roles(String value, Long id) {
		this.value = value;
		this.id = id;
	}

	public String getValue() {
		return value;
	}

	public Long getId() {
		return id;
	}
}
