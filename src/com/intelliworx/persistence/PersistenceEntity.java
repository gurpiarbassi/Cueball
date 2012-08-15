package com.intelliworx.persistence;

public class PersistenceEntity implements IPersistenceEntity {

	private Integer primaryKey;
	private int optCount;
	
	public Integer getPrimaryKey() {
		return primaryKey;
	}
	public void setPrimaryKey(Integer primaryKey) {
		this.primaryKey = primaryKey;
	}
	public int getOptCount() {
		return optCount;
	}
	public void setOptCount(int optCount) {
		this.optCount = optCount;
	}
	
	
}
