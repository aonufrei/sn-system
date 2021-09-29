package com.onufrei.sn.dao;

import com.onufrei.sn.exceptions.LikeException;
import com.onufrei.sn.mapper.LikeMapper;
import org.springframework.stereotype.Service;

@Service("CommentLikeDao")
public class CommentLikeDao implements LikeDao {

	private final LikeMapper likeMapper;

	public CommentLikeDao(LikeMapper likeMapper) {
		this.likeMapper = likeMapper;
	}

	@Override
	public void like(Long commentId, Long profileId) {
		try {
			likeMapper.addToComment(commentId, profileId);
		} catch (Exception e) {
			throw new LikeException("The comment(" + commentId + ") was already liked by this user(" + profileId + ")");
		}
	}

	@Override
	public void dislike(Long commentId, Long profileId) {
		likeMapper.deleteFromComment(commentId, profileId);
	}

	@Override
	public Long countLikes(Long commentId) {
		return likeMapper.countForComment(commentId);
	}

	@Override
	public Boolean wasLikedBy(Long commentId, Long profileId) {
		return likeMapper.commentWasLikedBy(commentId, profileId);
	}
}
