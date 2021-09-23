package com.onufrei.sn.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Account {
	private Long id;
	private String username;
	private String password;
	private LocalDateTime createdAt;
	private LocalDateTime modifiedAt;

	public Account(String username, String password) {
		this.username = username;
		this.password = password;
	}
}
