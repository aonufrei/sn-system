package com.onufrei.sn.dao;

import com.onufrei.sn.dto.CommentDto;
import com.onufrei.sn.dto.CommentInDto;
import com.onufrei.sn.mapper.CommentMapper;
import com.onufrei.sn.model.Comment;
import com.onufrei.sn.utils.CommentUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CommentDao {

	private final CommentMapper commentMapper;

	public CommentDao(CommentMapper commentMapper) {
		this.commentMapper = commentMapper;
	}

	public Long add(CommentInDto comment) {
		Comment commentToInsert = CommentUtils.toModel(comment);
		commentMapper.add(commentToInsert);
		return commentToInsert.getId();
	}

	public int update(Long id, CommentInDto comment) {
		return commentMapper.update(id, CommentUtils.toModel(comment));
	}

	public void delete(Long id) {
		commentMapper.delete(id);
	}

	public CommentDto getById(Long id) {
		return CommentUtils.toDto(commentMapper.getById(id));
	}

	public List<CommentDto> getForPost(Long id, Boolean newest, Long offset, Long limit) {
		return commentMapper.getForPost(id, newest, offset, limit).stream().map(CommentUtils::toDto).collect(Collectors.toList());
	}

}
