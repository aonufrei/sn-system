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
public class ProfileInDto {
	private String name;
	private String status;
	private Long accountId;
	@JsonProperty("date_of_birth")
	private LocalDate dateOfBirth;
	@JsonProperty("profile_image_url")
	private LocalDate profileImageUrl;
	private String hobbies;
}
