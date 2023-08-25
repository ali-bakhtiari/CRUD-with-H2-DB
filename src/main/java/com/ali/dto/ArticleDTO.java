package com.ali.dto;

import com.ali.enums.CategoryEnum;
import com.ali.enums.StatusEnum;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;

public class ArticleDTO {

	private Long id;

	private String title;

	@NotEmpty
	@Size(max = 400)
	private String content;

	private CategoryEnum categoryEnum;

	private StatusEnum statusEnum;

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

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public CategoryEnum getCategoryEnum() {
		return categoryEnum;
	}

	public void setCategoryEnum(CategoryEnum categoryEnum) {
		this.categoryEnum = categoryEnum;
	}

	public StatusEnum getStatusEnum() {
		return statusEnum;
	}

	public void setStatusEnum(StatusEnum statusEnum) {
		this.statusEnum = statusEnum;
	}
}
