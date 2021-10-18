package com.onufrei.sn.controller.rest;

import com.onufrei.sn.dto.PostDto;
import com.onufrei.sn.dto.PostInDto;
import com.onufrei.sn.exceptions.LikeException;
import com.onufrei.sn.service.PostService;
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
@RequestMapping("/posts")
public class PostRestController {

	private final PostService postService;

	public PostRestController(PostService postService) {
		this.postService = postService;
	}

	@PostMapping
	public Long addPost(@RequestBody PostInDto post) {
		return postService.add(post);
	}

	@PutMapping("/{id}")
	public Boolean updatePost(@PathVariable Long id, @RequestBody PostInDto post) {
		return postService.update(id, post);
	}

	@DeleteMapping("/{id}")
	public void deletePost(@PathVariable("id") Long id) {
		postService.delete(id);
	}

	@GetMapping("/{id}")
	public PostDto getPostById(@PathVariable("id") Long id) {
		return postService.getById(id);
	}

	@GetMapping("/by/{id}")
	public List<PostDto> getByUser(@PathVariable("id") Long userId, @RequestParam Boolean newest, @RequestParam Long offset, @RequestParam Long limit) {
		return postService.getByUser(userId, newest, offset, limit);
	}

	@GetMapping("/for/{id}")
	public List<PostDto> getForUser(@PathVariable("id") Long userId, @RequestParam Boolean newest, @RequestParam Long offset, @RequestParam Long limit) {
		return postService.getForUser(userId, newest, offset, limit);
	}

	@PostMapping("/{id}/like")
	public void like(@PathVariable("id") Long postId) throws LikeException {
		//TODO: Add profile from token method here
		postService.like(postId, 1L);
	}

	@PostMapping("/{id}/dislike")
	public void dislike(@PathVariable("id") Long postId) {
		//TODO: Add profile from token method here
		postService.dislike(postId, 1L);
	}

	@GetMapping("/{id}/likes")
	public Long countLikes(@PathVariable("id") Long postId) {
		return postService.countLikes(postId);
	}

	@GetMapping("/{id}/liked")
	public Boolean wasLikedBy(@PathVariable("id") Long postId) {
		//TODO: Add profile from token method here
		return postService.wasLikedBy(postId, 1L);
	}

}
