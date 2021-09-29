package com.onufrei.sn.mapper;

import com.onufrei.sn.model.Comment;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface CommentMapper {

	Long add(@Param("comment") Comment comment);

	int update(@Param("id") Long id, @Param("comment") Comment comment);

	void delete(@Param("id") Long id);

	Comment getById(@Param("id") Long id);

	List<Comment> getForPost(@Param("id") Long id, @Param("newest") Boolean newest, @Param("offset") Long offset, @Param("limit") Long limit);

}
