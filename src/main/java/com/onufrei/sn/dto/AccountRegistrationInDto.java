package com.onufrei.sn.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AccountRegistrationInDto {

	private String username;
	private String password;
	private String name;
	private String status;
	@JsonProperty("date_of_birth")
	private LocalDate dateOfBirth;
	@JsonProperty("profile_image")
	private String profileImage;

}
