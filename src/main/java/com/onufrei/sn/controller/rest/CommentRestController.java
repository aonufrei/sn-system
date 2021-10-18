package com.onufrei.sn.controller.rest;

import com.onufrei.sn.dto.CommentDto;
import com.onufrei.sn.dto.CommentInDto;
import com.onufrei.sn.exceptions.LikeException;
import com.onufrei.sn.service.CommentService;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/comments")
public class CommentRestController {

	private final CommentService commentService;

	public CommentRestController(CommentService commentService) {
		this.commentService = commentService;
	}

	@PostMapping
	public Long addComment(@RequestBody CommentInDto comment) {
		return commentService.add(comment);
	}

	@PutMapping("/{id}")
	public Boolean updateComment(@PathVariable Long id, @RequestBody CommentInDto comment) {
		return commentService.update(id, comment);
	}

	@DeleteMapping("/{id}")
	public void deleteComment(@PathVariable Long id) {
		commentService.delete(id);
	}

	@GetMapping("/{id}")
	public CommentDto getCommentById(@PathVariable Long id) {
		return commentService.getById(id);
	}

	@GetMapping("/{post_id}")
	public List<CommentDto> getForPost(@PathVariable("post_id") Long postId, @RequestParam Boolean newest, @RequestParam Long offset, @RequestParam Long limit) {
		return commentService.getForPost(postId, newest, offset, limit);
	}

	@PostMapping("/{id}/like")
	public void like(@PathVariable("id") Long commentId) throws LikeException {
		//TODO: Add profile from token method here
		commentService.like(commentId, 1L);
	}

	@PostMapping("/{id}/dislike")
	public void dislike(@PathVariable("id") Long commentId) {
		//TODO: Add profile from token method here
		commentService.dislike(commentId, 1L);
	}

	@GetMapping("/{id}/likes")
	public Long countLikes(@PathVariable("id") Long commentId) {
		return commentService.countLikes(commentId);
	}

	@GetMapping("/{id}/status")
	public Boolean wasLikedBy(@PathVariable("id") Long commentId, Long profileId) {
		//TODO: Add profile from token method here
		return commentService.wasLikedBy(commentId, 1L);
	}

}
