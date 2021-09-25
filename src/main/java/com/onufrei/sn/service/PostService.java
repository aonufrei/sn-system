package com.onufrei.sn.service;

import com.onufrei.sn.dao.PostDao;
import com.onufrei.sn.dto.PostDto;
import com.onufrei.sn.dto.PostInDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostService {

	private final PostDao postDao;

	public PostService(PostDao postDao) {
		this.postDao = postDao;
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

}
