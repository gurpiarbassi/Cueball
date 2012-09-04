package com.intelliworx.persistence;

import java.util.Date;

public class PersistenceEntity implements IPersistenceEntity {

	private Integer primaryKey;
	private Date dateCreated;
	private Date dateModified;
	private int optCount;
	
	public Integer getPrimaryKey() {
		return primaryKey;
	}
	public void setPrimaryKey(Integer primaryKey) {
		this.primaryKey = primaryKey;
	}
	public Date getDateCreated() {
		return dateCreated;
	}
	public void setDateCreated(Date dateCreated) {
		this.dateCreated = dateCreated;
	}
	public Date getDateModified() {
		return dateModified;
	}
	public void setDateModified(Date dateModified) {
		this.dateModified = dateModified;
	}
	public int getOptCount() {
		return optCount;
	}
	public void setOptCount(int optCount) {
		this.optCount = optCount;
	}
	
	
}
