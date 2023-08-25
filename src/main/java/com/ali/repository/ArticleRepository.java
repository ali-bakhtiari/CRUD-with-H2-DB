package com.ali.repository;

import com.ali.entity.ArticleEntity;
import com.ali.enums.CategoryEnum;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ArticleRepository extends JpaRepository<ArticleEntity, Long> {

	//    @Query("SELECT * FROM ArticleEntity article Where article.categoryEnum:categoryEnum")
	List<ArticleEntity> findByCategoryEnum(CategoryEnum categoryEnum);

	List<ArticleEntity> findByTitleContainingIgnoreCase(String title);
}
