package com.intelliworx.persistence;

import org.joda.time.LocalDateTime;

public interface IPersistenceEntity {
	
	public Integer getPrimaryKey();
	public void setPrimaryKey(Integer primaryKey);
	public LocalDateTime getDateCreated();
	public void setDateCreated(LocalDateTime dateCreated);
	public LocalDateTime getDateModified();
	public void setDateModified(LocalDateTime dateModified);
	public int getOptCount();
	public void setOptCount(int optCount);
}
