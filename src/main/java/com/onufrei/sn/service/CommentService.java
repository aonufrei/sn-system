package com.onufrei.sn.service;

import com.onufrei.sn.dao.CommentDao;
import com.onufrei.sn.dto.CommentDto;
import com.onufrei.sn.dto.CommentInDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentService {

	private final CommentDao commentDao;

	public CommentService(CommentDao commentDao) {
		this.commentDao = commentDao;
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


}
