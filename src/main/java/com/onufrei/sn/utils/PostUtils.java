package com.onufrei.sn.utils;

import com.onufrei.sn.dto.PostDto;
import com.onufrei.sn.dto.PostInDto;
import com.onufrei.sn.model.Post;

public class PostUtils {

	public static Post toModel(PostInDto postInDto) {
		if (postInDto == null) return null;

		return Post.builder()
				.profileId(postInDto.getProfileId())
				.content(postInDto.getContent())
				.build();
	}

	public static PostDto toDto(Post post) {
		if (post == null) return null;

		return PostDto.builder()
				.id(post.getId())
				.profileId(post.getProfileId())
				.content(post.getContent())
				.createdAt(post.getCreatedAt())
				.modifiedAt(post.getModifiedAt())
				.build();
	}

}
