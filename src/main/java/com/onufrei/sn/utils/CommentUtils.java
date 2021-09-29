package com.onufrei.sn.utils;

import com.onufrei.sn.dto.CommentDto;
import com.onufrei.sn.dto.CommentInDto;
import com.onufrei.sn.model.Comment;

public class CommentUtils {

	public static Comment toModel(CommentInDto commentInDto) {
		if (commentInDto == null) return null;

		return Comment.builder()
				.profileId(commentInDto.getProfileId())
				.content(commentInDto.getContent())
				.targetPostId(commentInDto.getTargetPostId())
				.targetCommentId(commentInDto.getTargetCommentId())
				.build();
	}

	public static CommentDto toDto(Comment comment) {
		if (comment == null) return null;

		return CommentDto.builder()
				.id(comment.getId())
				.profileId(comment.getProfileId())
				.content(comment.getContent())
				.targetPostId(comment.getTargetPostId())
				.targetCommentId(comment.getTargetCommentId())
				.createdAt(comment.getCreatedAt())
				.modifiedAt(comment.getModifiedAt())
				.build();
	}


}
