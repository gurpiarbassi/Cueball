package com.intelliworx.persistence;

import org.joda.time.LocalDateTime;

public class PersistenceEntity implements IPersistenceEntity {

	private Integer primaryKey;
	private LocalDateTime dateCreated;
	private LocalDateTime dateModified;
	private int optCount;
	
	public Integer getPrimaryKey() {
		return primaryKey;
	}
	public void setPrimaryKey(Integer primaryKey) {
		this.primaryKey = primaryKey;
	}
	public LocalDateTime getDateCreated() {
		return dateCreated;
	}
	public void setDateCreated(LocalDateTime dateCreated) {
		this.dateCreated = dateCreated;
	}
	public LocalDateTime getDateModified() {
		return dateModified;
	}
	public void setDateModified(LocalDateTime dateModified) {
		this.dateModified = dateModified;
	}
	public int getOptCount() {
		return optCount;
	}
	public void setOptCount(int optCount) {
		this.optCount = optCount;
	}
	
	
}
