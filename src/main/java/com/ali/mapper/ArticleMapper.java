package com.ali.mapper;

import com.ali.dto.ArticleDTO;
import com.ali.entity.ArticleEntity;
import com.ali.entity.CategoryEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ArticleMapper {
@Mapping(source = "categoryEntity.id" , target = "categoryId")
    ArticleDTO entityToDTO(ArticleEntity articleEntity);

    List<ArticleDTO> entityToDTOList(List<ArticleEntity> articleEntityList);
@Mapping(source ="categoryId", target = "categoryEntity.id")
    ArticleEntity dtoToEntity(ArticleDTO articleDTO);

    List<ArticleEntity> dtoToEntityList(List<ArticleDTO> articleDTOList);

}
