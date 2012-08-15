package com.intelliworx.persistence;

public interface IPersistenceEntity {
	
	public Integer getPrimaryKey();
	public void setPrimaryKey(Integer primaryKey);
	public int getOptCount();
	public void setOptCount(int optCount);
}
