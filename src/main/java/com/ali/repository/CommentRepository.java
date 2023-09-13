package com.ali.repository;

import com.ali.entity.CommentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommentRepository extends JpaRepository<CommentEntity, Long> {

    @Query("SELECT c FROM CommentEntity c WHERE c.articleEntity.id=:articleId ")
    List<CommentEntity> findAllByArticleId(Long articleId);
}
