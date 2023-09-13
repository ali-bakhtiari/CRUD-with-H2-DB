package com.ali.controller;

import com.ali.dto.ArticleDTO;
import com.ali.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javax.validation.Valid;
import java.util.List;

@RestController
public class ArticleManagementController {

    @Autowired
    ArticleService articleService;

    @PostMapping("/articles")
    public ResponseEntity<ArticleDTO> createArticle(@RequestBody @Valid ArticleDTO articleDTO) {
        ArticleDTO createdArticleDTO = articleService.createArticle(articleDTO);
        return new ResponseEntity<>(createdArticleDTO, HttpStatus.CREATED);
    }

    @GetMapping("/articles")
    public ResponseEntity<List<ArticleDTO>> getAllArticles(@RequestParam(required = false) String title) {

        List<ArticleDTO> articleDTOList = articleService.getAllArticles(title);
        if (articleDTOList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(articleDTOList, HttpStatus.OK);
    }

//    @GetMapping("/articles/category")
//    public ResponseEntity<List<ArticleDTO>> findByCategoryEnum(CategoryEnum categoryEnum) {
//
//        List<ArticleDTO> articleDTOList = articleService.findByCategoryEnum(categoryEnum);
//        if (articleDTOList.isEmpty()) {
//            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
//        }
//        return new ResponseEntity<>(articleDTOList, HttpStatus.OK);
//    }

    @GetMapping("/articles/{id}")
    public ResponseEntity<ArticleDTO> getArticleById(@PathVariable("id") Long id) {

        ArticleDTO articleDTO = articleService.getArticleById(id);
        return new ResponseEntity<>(articleDTO, HttpStatus.OK);
    }

    @GetMapping("/articles/category_id")
    public ResponseEntity<List<ArticleDTO>> getArticleListByCategoryId(Long categoryId) {
        List<ArticleDTO> articleDTOList = articleService.getArticleListByCategoryId(categoryId);
        if (articleDTOList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.BAD_GATEWAY);
        }
        return new ResponseEntity<>(articleDTOList,HttpStatus.OK);
    }

    @PutMapping("/articles/{id}")
    public ResponseEntity<ArticleDTO> updateArticle(@PathVariable("id") Long id, @RequestBody @Valid ArticleDTO articleDTO) {

        ArticleDTO articleDTOAfterUpdate = articleService.updateArticle(id, articleDTO);

        if (articleDTOAfterUpdate != null) {
            return new ResponseEntity<>(articleDTOAfterUpdate, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/articles/{id}")
    public ResponseEntity<HttpStatus> deleteArticle(@PathVariable("id") Long id) {
        articleService.deleteArticle(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping("/articles")
    public ResponseEntity<HttpStatus> deleteAllArticles() {
        try {
            articleService.deleteAllArticles();
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
