package com.ali.service;

import com.ali.dto.CommentDTO;

import java.util.List;

public interface CommentService {

	CommentDTO createComment(CommentDTO commentDTO);

	CommentDTO getCommentById(Long id);

	List<CommentDTO> getCommentListByArticleId(Long articleId);

	List<CommentDTO> getAllComments();

	void deleteComment(Long id);

	void deleteAllComment();

	CommentDTO updateComment(Long id, CommentDTO commentDTO);
}

