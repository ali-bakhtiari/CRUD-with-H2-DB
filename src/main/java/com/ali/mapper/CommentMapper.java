package com.ali.mapper;

import com.ali.dto.CommentDTO;
import com.ali.entity.CommentEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CommentMapper {

    @Mapping(source = "articleEntity.id", target = "articleId")
    CommentDTO entityToDTO(CommentEntity commentEntity);

    @Mapping(source = "articleId", target = "articleEntity.id")
    CommentEntity dtoToEntity(CommentDTO commentDTO);

    List<CommentEntity> dtoToEntityList(List<CommentDTO> commentDTO);

    List<CommentDTO> entityToDTOList(List<CommentEntity> commentEntity);
}