package com.onufrei.sn.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProfileDto {
	private Long id;
	private String name;
	private String status;
	private Long accountId;
	@JsonProperty("date_of_birth")
	private LocalDate dateOfBirth;
	@JsonProperty("profile_image_url")
	private String profileImageUrl;
	private String hobbies;
	@JsonProperty("created_at")
	private LocalDateTime createdAt;
	@JsonProperty("modified_at")
	private LocalDateTime modifiedAt;
}
