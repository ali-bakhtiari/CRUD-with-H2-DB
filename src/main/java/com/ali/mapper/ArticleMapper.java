package com.ali.mapper;

import com.ali.dto.ArticleDTO;
import com.ali.entity.ArticleEntity;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ArticleMapper {

	ArticleDTO entityToDTO(ArticleEntity articleEntity);

	List<ArticleDTO> entityToDTOList(List<ArticleEntity> articleEntityList);

	ArticleEntity dtoToEntity(ArticleDTO articleDTO);

	List<ArticleEntity> dtoToEntityList(List<ArticleDTO> articleDTOList);

}
