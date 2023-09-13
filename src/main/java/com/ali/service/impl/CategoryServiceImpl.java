package com.ali.service.impl;

import com.ali.dto.CategoryDTO;
import com.ali.entity.CategoryEntity;
import com.ali.mapper.CategoryMapper;
import com.ali.repository.CategoryRepository;
import com.ali.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    CategoryMapper categoryMapper;

    @Autowired
    CategoryRepository categoryRepository;
    @Override
    public CategoryDTO createCategory(CategoryDTO categoryDTO) {
        CategoryEntity categoryEntityBeforeSave = categoryMapper.dtoToEntity(categoryDTO);
        CategoryEntity categoryEntityAfterSave = categoryRepository.save(categoryEntityBeforeSave);
        return categoryMapper.entityToDTO(categoryEntityAfterSave);
    }

    @Override
    public List<CategoryDTO> getAllCategory() {
        List<CategoryEntity> categoryEntityList = categoryRepository.findAll();
        return categoryMapper.entityToDTOList(categoryEntityList);
    }

    @Override
    public CategoryDTO getCategoryById(Long id) {
        CategoryEntity categoryEntity = categoryRepository.getById(id);
        return categoryMapper.entityToDTO(categoryEntity);
    }

    @Override
    public CategoryDTO updateCategory(Long id, CategoryDTO categoryDTO) {
        CategoryEntity categoryEntityById = categoryRepository.getById(id);
        categoryEntityById.setTitle(categoryDTO.getTitle());
        CategoryEntity categoryAfterUpdate = categoryRepository.save(categoryEntityById);
        return categoryMapper.entityToDTO(categoryAfterUpdate);
    }

    @Override
    public void deleteCategory(Long id) {
        categoryRepository.deleteById(id);
    }
}
