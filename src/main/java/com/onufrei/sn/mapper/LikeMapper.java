package com.onufrei.sn.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface LikeMapper {

	int addToPost(@Param("post_id") Long postId, @Param("profile_id") Long profileId);

	int addToComment(@Param("comment_id") Long commentId, @Param("profile_id") Long profileId);

	void deleteFromPost(@Param("post_id") Long postId, @Param("profile_id") Long profileId);

	void deleteFromComment(@Param("comment_id") Long commentId, @Param("profile_id") Long profileId);

	Long countForPost(@Param("post_id") Long postId);

	Long countForComment(@Param("comment_id") Long commentId);

	Boolean postWasLikedBy(@Param("post_id") Long postId, @Param("profile_id") Long profileId);

	Boolean commentWasLikedBy(@Param("comment_id") Long commentId, @Param("profile_id") Long profileId);

}
