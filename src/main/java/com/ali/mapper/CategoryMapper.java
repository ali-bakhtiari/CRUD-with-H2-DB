package com.ali.mapper;

import com.ali.dto.ArticleDTO;
import com.ali.dto.CategoryDTO;
import com.ali.entity.ArticleEntity;
import com.ali.entity.CategoryEntity;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CategoryMapper {

    CategoryDTO entityToDTO(CategoryEntity categoryEntity);

    List<CategoryDTO> entityToDTOList(List<CategoryEntity> categoryEntityList);

    CategoryEntity dtoToEntity(CategoryDTO categoryDTO);



}
