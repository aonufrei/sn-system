package com.onufrei.sn.dao;

import com.onufrei.sn.exceptions.LikeException;
import com.onufrei.sn.mapper.LikeMapper;
import org.springframework.stereotype.Service;

@Service("PostLikeDao")
public class PostLikeDao implements LikeDao {

	private final LikeMapper likeMapper;

	public PostLikeDao(LikeMapper likeMapper) {
		this.likeMapper = likeMapper;
	}

	@Override
	public void like(Long postId, Long profileId) throws LikeException {
		try {
			likeMapper.addToPost(postId, profileId);
		} catch (Exception e) {
			throw new LikeException("The post(" + postId + ") was already liked by this user(" + profileId + ")");
		}
	}

	@Override
	public void dislike(Long postId, Long profileId) {
		likeMapper.deleteFromPost(postId, profileId);
	}

	@Override
	public Long countLikes(Long postId) {
		return likeMapper.countForPost(postId);
	}

	@Override
	public Boolean wasLikedBy(Long postId, Long profileId) {
		return likeMapper.postWasLikedBy(postId, profileId);
	}

}
