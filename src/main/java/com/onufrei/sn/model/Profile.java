package com.onufrei.sn.model;

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
public class Profile {
	private Long id;
	private String name;
	private String status;
	private Long accountId;
	private LocalDate dateOfBirth;
	private String profileImageUrl;
	private String hobbies;
	private LocalDateTime createdAt;
	private LocalDateTime modifiedAt;
}