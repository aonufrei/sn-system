package com.onufrei.sn.model;

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
public class Post {
	private Long id;
	@JsonProperty("profile_id")
	private Integer profileId;
	private String content;
	@JsonProperty("created_at")
	private LocalDateTime createdAt;
	@JsonProperty("modified_at")
	private LocalDateTime modifiedAt;
}
