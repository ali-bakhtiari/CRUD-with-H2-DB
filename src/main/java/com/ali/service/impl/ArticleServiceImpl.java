package com.ali.service.impl;

import com.ali.dto.ArticleDTO;
import com.ali.entity.ArticleEntity;
import com.ali.mapper.ArticleMapper;
import com.ali.repository.ArticleRepository;
import com.ali.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ArticleServiceImpl implements ArticleService {

    @Autowired
    ArticleRepository articleRepository;

    @Autowired
    ArticleMapper articleMapper;

    @Override
    public List<ArticleDTO> getAllArticles(String title) {

        List<ArticleEntity> articleEntityList = new ArrayList<>();

        if (title == null) {
            articleEntityList.addAll(articleRepository.findAll());
        } else
            articleEntityList.addAll(articleRepository.findByTitleContainingIgnoreCase(title));

        return articleMapper.entityToDTOList(articleEntityList);
    }

//    @Override
//    public List<ArticleDTO> findByCategoryEnum(CategoryEnum categoryEnum) {
//
//        List<ArticleEntity> articleEntityList = articleRepository.findByCategoryEnum(categoryEnum);
//        return articleMapper.entityToDTOList(articleEntityList);
//    }

    @Override
    public ArticleDTO getArticleById(Long id) {

        Optional<ArticleEntity> optionalArticleEntity = articleRepository.findById(id);

        if (!optionalArticleEntity.isPresent()) {
            return null;
        }

        ArticleEntity articleEntity = optionalArticleEntity.get();

        return articleMapper.entityToDTO(articleEntity);
    }

    @Override
    public ArticleDTO createArticle(ArticleDTO articleDTO) {

        ArticleEntity articleEntityBeforeSave = articleMapper.dtoToEntity(articleDTO);

        ArticleEntity articleEntityAfterSave = articleRepository.save(articleEntityBeforeSave);

        return articleMapper.entityToDTO(articleEntityAfterSave);
    }

    @Override
    public ArticleDTO updateArticle(Long id, ArticleDTO articleDTO) {

        Optional<ArticleEntity> optionalArticleEntity = articleRepository.findById(id);

        if (optionalArticleEntity.isPresent()) {
            ArticleEntity articleEntity = optionalArticleEntity.get();
            articleEntity.setTitle(articleDTO.getTitle());
            articleEntity.setContent(articleDTO.getContent());
            ArticleEntity articleEntityBeforeSave = articleRepository.save(articleEntity);
            return articleMapper.entityToDTO(articleEntityBeforeSave);
        }
        return null;
    }

    @Override
    public void deleteArticle(Long id) {
        articleRepository.deleteById(id);
    }

    @Override
    public void deleteAllArticles() {
        articleRepository.deleteAll();
    }

    @Override
    public List<ArticleDTO> getArticleListByCategoryId(Long categoryId) {
        List<ArticleEntity> articleEntityList = articleRepository.findAllListByCategoryId(categoryId);
        return articleMapper.entityToDTOList(articleEntityList);
    }
}
