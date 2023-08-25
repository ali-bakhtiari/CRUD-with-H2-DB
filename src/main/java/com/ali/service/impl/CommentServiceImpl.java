package com.ali.service.impl;

import com.ali.dto.CommentDTO;
import com.ali.entity.CommentEntity;
import com.ali.mapper.CommentMapper;
import com.ali.repository.CommentRepository;
import com.ali.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class
CommentServiceImpl implements CommentService {

	@Autowired
	CommentMapper commentMapper;

	@Autowired
	CommentRepository commentRepository;

	@Override
	public CommentDTO createComment(CommentDTO commentDTO) {

		CommentEntity commentEntity = commentMapper.dtoToEntity(commentDTO);

//		ArticleEntity articleEntity = new ArticleEntity();
//		articleEntity.setId(commentDTO.getArticleId());
//		commentEntity.setArticleEntity(articleEntity);

		CommentEntity commentEntityAfterSave = commentRepository.save(commentEntity);
		return commentMapper.entityToDTO(commentEntityAfterSave);
	}

	@Override
	public CommentDTO getCommentById(Long id) {

		CommentEntity commentEntityById = commentRepository.getById(id);
		return commentMapper.entityToDTO(commentEntityById);
	}

	@Override
	public List<CommentDTO> getCommentListByArticleId(Long articleId) {

		List<CommentEntity> commentEntityList = commentRepository.findAllByArticleId(articleId);
		return commentMapper.entityToDTOList(commentEntityList);
	}

	@Override
	public List<CommentDTO> getAllComments() {

		List<CommentEntity> commentEntityList = commentRepository.findAll();
		return commentMapper.entityToDTOList(commentEntityList);
	}

	@Override
	public void deleteComment(Long id) {

		commentRepository.deleteById(id);
	}

	@Override
	public void deleteAllComment() {

		commentRepository.deleteAll();
	}

	@Override
	public CommentDTO updateComment(Long id, CommentDTO commentDTO) {

		CommentEntity commentEntityById = commentRepository.getById(id);
		commentEntityById.setArticleComment(commentDTO.getArticleComment());
		CommentEntity afterUpdate = commentRepository.save(commentEntityById);
		return commentMapper.entityToDTO(afterUpdate);
	}
}
