package com.onufrei.sn.service;

import com.onufrei.sn.dao.CommentDao;
import com.onufrei.sn.dao.LikeDao;
import com.onufrei.sn.dto.CommentDto;
import com.onufrei.sn.dto.CommentInDto;
import com.onufrei.sn.exceptions.LikeException;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentService {

	private final CommentDao commentDao;
	private final LikeDao likeDao;

	public CommentService(CommentDao commentDao, @Qualifier("CommentLikeDao") LikeDao likeDao) {
		this.commentDao = commentDao;
		this.likeDao = likeDao;
	}

	public Long add(CommentInDto comment) {
		return commentDao.add(comment);
	}

	public Boolean update(Long id, CommentInDto comment) {
		return commentDao.update(id, comment) > 0;
	}

	public void delete(Long id) {
		commentDao.delete(id);
	}

	public CommentDto getById(Long id) {
		return commentDao.getById(id);
	}

	public List<CommentDto> getForPost(Long id, Boolean newest, Long offset, Long limit) {
		return commentDao.getForPost(id, newest, offset, limit);
	}

	void like(Long commentId, Long profileId) throws LikeException {
		likeDao.like(commentId, profileId);
	}

	void dislike(Long commentId, Long profileId) {
		likeDao.dislike(commentId, profileId);
	}

	Long countLikes(Long commentId) {
		return likeDao.countLikes(commentId);
	}

	Boolean wasLikedBy(Long commentId, Long profileId) {
		return likeDao.wasLikedBy(commentId, profileId);
	}

}
