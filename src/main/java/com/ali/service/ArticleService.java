package com.ali.service;

import com.ali.dto.ArticleDTO;
import com.ali.enums.CategoryEnum;

import java.util.List;

public interface ArticleService {

	List<ArticleDTO> getAllArticles(String title);

	List<ArticleDTO> findByCategoryEnum(CategoryEnum categoryEnum);

	ArticleDTO getArticleById(Long id);

	ArticleDTO createArticle(ArticleDTO articleDTO);

	ArticleDTO updateArticle(Long id, ArticleDTO articleDTO);

	void deleteArticle(Long id);

	void deleteAllArticles();
}
