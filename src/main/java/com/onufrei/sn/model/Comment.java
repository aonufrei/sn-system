package com.onufrei.sn.model;

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
	private Long profileId;
	private String content;
	private Long targetPostId;
	private Long targetCommentId;
	private LocalDateTime createdAt;
	private LocalDateTime modifiedAt;
}
