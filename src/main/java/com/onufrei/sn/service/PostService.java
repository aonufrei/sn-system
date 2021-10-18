package com.onufrei.sn.service;

import com.onufrei.sn.dao.LikeDao;
import com.onufrei.sn.dao.PostDao;
import com.onufrei.sn.dto.PostDto;
import com.onufrei.sn.dto.PostInDto;
import com.onufrei.sn.exceptions.LikeException;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostService {

	private final PostDao postDao;
	private final LikeDao likeDao;

	public PostService(PostDao postDao, @Qualifier("PostLikeDao") LikeDao likeDao) {
		this.postDao = postDao;
		this.likeDao = likeDao;
	}

	public Long add(PostInDto post) {
		return postDao.add(post);
	}

	public Boolean update(Long id, PostInDto post) {
		return postDao.update(id, post) > 0;
	}

	public void delete(Long id) {
		postDao.delete(id);
	}

	public PostDto getById(Long id) {
		return postDao.getById(id);
	}

	public List<PostDto> getByUser(Long userId, Boolean newest, Long offset, Long limit) {
		return postDao.getByUser(userId, newest, offset, limit);
	}

	public List<PostDto> getForUser(Long userId, Boolean newest, Long offset, Long limit) {
		return postDao.getForUser(userId, newest, offset, limit);
	}

	public void like(Long postId, Long profileId) throws LikeException {
		likeDao.like(postId, profileId);
	}

	public void dislike(Long postId, Long profileId) {
		likeDao.dislike(postId, profileId);
	}

	public Long countLikes(Long postId) {
		return likeDao.countLikes(postId);
	}

	public Boolean wasLikedBy(Long postId, Long profileId) {
		return likeDao.wasLikedBy(postId, profileId);
	}
}
