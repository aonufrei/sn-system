package com.onufrei.sn.dao;

import com.onufrei.sn.exceptions.LikeException;
import org.springframework.stereotype.Service;

@Service
public interface LikeDao {

	void like(Long contentId, Long profileId) throws LikeException;

	void dislike(Long contentId, Long profileId);

	Long countLikes(Long contentId);

	Boolean wasLikedBy(Long contentId, Long profileId);

}
