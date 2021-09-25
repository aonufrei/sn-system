package com.onufrei.sn.mapper;

import com.onufrei.sn.model.Post;
import com.sun.istack.internal.NotNull;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface PostMapper {

	Long add(@Param("post") Post post);

	int update(@Param("id") Long id, @Param("post") Post post);

	void delete(@Param("id") Long id);

	Post getById(@Param("id") Long id);

	List<Post> getByUser(@Param("user_id") Long userId, @NotNull @Param("newest") Boolean newest, @NotNull @Param("offset") Long offset,
			@NotNull @Param("limit") Long limit);

	List<Post> getForUser(@Param("user_id") Long userId, @NotNull @Param("newest") Boolean newest, @NotNull @Param("offset") Long offset,
			@NotNull @Param("limit") Long limit);

}
