package com.onufrei.sn.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.onufrei.sn.constants.CommentType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Comment {
	private Long id;
	@JsonProperty("profile_id")
	private Integer profileId;
	private String content;
	private CommentType type;
	@JsonProperty("content_id")
	private Integer contentId;
	@JsonProperty("created_at")
	private LocalDateTime createdAt;
	@JsonProperty("modified_at")
	private LocalDateTime modifiedAt;
}
