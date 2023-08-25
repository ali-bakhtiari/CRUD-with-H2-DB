package com.ali.controller;

import com.ali.dto.CommentDTO;
import com.ali.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class CommentController {

	@Autowired
	CommentService commentService;

	@PostMapping("/comments")
	public ResponseEntity<CommentDTO> createComment(@RequestBody @Valid CommentDTO commentDTO) {
		CommentDTO createdCommentDTO = commentService.createComment(commentDTO);
		return new ResponseEntity<>(createdCommentDTO, HttpStatus.CREATED);
	}

	@GetMapping("/comments/{id}")
	public ResponseEntity<CommentDTO> getCommentById(@PathVariable("id") Long id) {

		CommentDTO commentDTO = commentService.getCommentById(id);
		return new ResponseEntity<>(commentDTO, HttpStatus.OK);
	}

	@GetMapping("/comments/articleId")
	public ResponseEntity<List<CommentDTO>> getCommentListByArticleId(Long articleId) {
		List<CommentDTO> commentDTOList = commentService.getCommentListByArticleId(articleId);
		if (commentDTOList.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<>(commentDTOList, HttpStatus.OK);
	}

	@GetMapping("/comments")
	public ResponseEntity<List<CommentDTO>> getAllComments() {

		List<CommentDTO> articleDTOList = commentService.getAllComments();
		if (articleDTOList.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} else {
			return new ResponseEntity<>(articleDTOList, HttpStatus.OK);
		}

	}

	@PutMapping("/comments/{id}")
	public ResponseEntity<CommentDTO> updateComment(@PathVariable("id") Long id, @RequestBody @Valid CommentDTO commentDTO) {

		CommentDTO updateDTOAfterUpdate = commentService.updateComment(id, commentDTO);

		if (updateDTOAfterUpdate != null) {
			return new ResponseEntity<>(updateDTOAfterUpdate, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@DeleteMapping("/comments/{id}")
	public ResponseEntity<HttpStatus> deleteComment(@PathVariable("id") Long id) {
		commentService.deleteComment(id);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}

	@DeleteMapping("/comments")
	public ResponseEntity<HttpStatus> deleteAllComments() {
		try {
			commentService.deleteAllComment();
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}