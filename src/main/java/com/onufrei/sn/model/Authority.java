package com.onufrei.sn.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Authority {
	private Long id;
	private String name;

	public Authority(String name) {
		this.name = name;
	}
}
