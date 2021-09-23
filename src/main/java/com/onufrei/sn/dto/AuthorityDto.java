package com.onufrei.sn.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AuthorityDto {
	private Long id;
	private String name;

	public AuthorityDto(String name) {
		this.name = name;
	}
}