package com.ali.repository;

import com.ali.entity.ArticleEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ArticleRepository extends JpaRepository<ArticleEntity, Long> {

	List<ArticleEntity> findByTitleContainingIgnoreCase(String title);

	@Query("SELECT a FROM ArticleEntity a where a.categoryEntity.id=:categoryId")
	List<ArticleEntity> findAllListByCategoryId(Long categoryId);

//	   @Query("SELECT * FROM ArticleEntity article Where article.categoryEnum:categoryEnum")
//	  List<ArticleEntity> findByCategoryEnum(CategoryEnum categoryEnum);

//    List <ArticleEntity> findByTitle(String title);
}
