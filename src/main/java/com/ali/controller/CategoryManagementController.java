package com.ali.controller;

import com.ali.dto.CategoryDTO;
import com.ali.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class CategoryManagementController {

    @Autowired
    CategoryService categoryService;

    @PostMapping("/categories")
    public ResponseEntity<CategoryDTO> createCategory(@RequestBody @Valid CategoryDTO categoryDTO) {
        CategoryDTO createdCategoryDTO = categoryService.createCategory(categoryDTO);
        return new ResponseEntity<>(createdCategoryDTO, HttpStatus.CREATED);
    }

    @GetMapping("/categories")
    public ResponseEntity<List<CategoryDTO>> getAllCategory() {
        List<CategoryDTO> categoryDTOList = categoryService.getAllCategory();
        if (categoryDTOList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(categoryDTOList, HttpStatus.OK);
        }
    }

    @GetMapping("/categories/byid")
    public ResponseEntity<CategoryDTO> getCategoryById(Long id){
        CategoryDTO categoryDTO = categoryService.getCategoryById(id);
        return new ResponseEntity<>(categoryDTO,HttpStatus.OK);
    }


    @PutMapping("/categories/update")
    public ResponseEntity<CategoryDTO> updateCategory(Long id , CategoryDTO categoryDTO){
        CategoryDTO updateCategoryAfterSave = categoryService.updateCategory(id,categoryDTO);
        if (updateCategoryAfterSave != null) {
            return new ResponseEntity<>(updateCategoryAfterSave, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }


    @DeleteMapping("/categories/byid")
    ResponseEntity<CategoryDTO> deleteCategory (Long id){
        categoryService.deleteCategory(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}