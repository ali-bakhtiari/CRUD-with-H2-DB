package com.ali.service;

import com.ali.dto.CategoryDTO;

import java.util.List;

public interface CategoryService {
    CategoryDTO createCategory(CategoryDTO categoryDTO);

    List<CategoryDTO> getAllCategory();


    CategoryDTO getCategoryById(Long id);


    CategoryDTO updateCategory(Long id , CategoryDTO categoryDTO);

    void deleteCategory(Long id);
}
