package com.ali.entity;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "comment")
public class CommentEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column(name = "articleComment", nullable = false)
	private String articleComment;

	@ManyToOne(fetch = FetchType.EAGER, optional = false)
	@JoinColumn(name = "article_id", nullable = false)
	private ArticleEntity articleEntity;

	@CreationTimestamp
	private LocalDateTime createDateTime;

	@UpdateTimestamp
	private LocalDateTime updateDateTime;

	public ArticleEntity getArticleEntity() {
		return articleEntity;
	}

	public void setArticleEntity(ArticleEntity articleEntity) {
		this.articleEntity = articleEntity;
	}

	public LocalDateTime getCreateDateTime() {
		return createDateTime;
	}

	public void setCreateDateTime(LocalDateTime createDateTime) {
		this.createDateTime = createDateTime;
	}

	public LocalDateTime getUpdateDateTime() {
		return updateDateTime;
	}

	public void setUpdateDateTime(LocalDateTime updateDateTime) {
		this.updateDateTime = updateDateTime;
	}

	public String getArticleComment() {
		return articleComment;
	}

	public void setArticleComment(String articleComment) {
		this.articleComment = articleComment;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
}
