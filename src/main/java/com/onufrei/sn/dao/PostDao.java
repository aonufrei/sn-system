package com.onufrei.sn.dao;

import com.onufrei.sn.dto.PostDto;
import com.onufrei.sn.dto.PostInDto;
import com.onufrei.sn.mapper.PostMapper;
import com.onufrei.sn.model.Post;
import com.onufrei.sn.utils.PostUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PostDao {

	private final PostMapper postMapper;

	public PostDao(PostMapper postMapper) {
		this.postMapper = postMapper;
	}

	public Long add(PostInDto post) {
		Post postToInsert = PostUtils.toModel(post);
		postMapper.add(postToInsert);
		return postToInsert.getId();
	}

	public int update(Long id, PostInDto post) {
		return postMapper.update(id, PostUtils.toModel(post));
	}

	public void delete(Long id) {
		postMapper.delete(id);
	}

	public PostDto getById(Long id) {
		return PostUtils.toDto(postMapper.getById(id));
	}

	public List<PostDto> getByUser(Long userId, Boolean newest, Long offset, Long limit) {
		return postMapper.getByUser(userId, newest, offset, limit).stream().map(PostUtils::toDto).collect(Collectors.toList());
	}

	public List<PostDto> getForUser(Long userId, Boolean newest, Long offset, Long limit){
		return postMapper.getForUser(userId, newest, offset, limit).stream().map(PostUtils::toDto).collect(Collectors.toList());
	}

}
