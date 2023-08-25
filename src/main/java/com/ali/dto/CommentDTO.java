package com.ali.dto;

import javax.validation.constraints.NotEmpty;
import java.time.LocalDateTime;

public class CommentDTO {

	private Long id;

	private Long articleId;

	@NotEmpty
	private String articleComment;

	private LocalDateTime createDateTime;

	private LocalDateTime updateDateTime;

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

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getArticleId() {
		return articleId;
	}

	public void setArticleId(Long articleId) {
		this.articleId = articleId;
	}

	public String getArticleComment() {
		return articleComment;
	}

	public void setArticleComment(String articleComment) {
		this.articleComment = articleComment;
	}
}
