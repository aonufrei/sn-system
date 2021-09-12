package com.onufrei.sn.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AccountDto {
	private Long id;
	private String username;
	private String password;
	@JsonProperty("created_at")
	private LocalDateTime createdAt;
	@JsonProperty("modified_at")
	private LocalDateTime modifiedAt;
}
