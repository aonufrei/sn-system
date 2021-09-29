package com.onufrei.sn.dto;

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
public class CommentDto {
	private Long id;
	@JsonProperty("profile_id")
	private Long profileId;
	private String content;
	@JsonProperty("target_post_id")
	private Long targetPostId;
	@JsonProperty("target_comment_id")
	private Long targetCommentId;
	@JsonProperty("created_at")
	private LocalDateTime createdAt;
	@JsonProperty("modified_at")
	private LocalDateTime modifiedAt;
}
