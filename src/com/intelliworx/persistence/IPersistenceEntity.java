package com.intelliworx.persistence;

import org.joda.time.LocalDateTime;

public interface IPersistenceEntity extends IObjectState{
	
	public static final int ACTION_INSERT = 1;
	public static final int ACTION_UPDATE = 2;
	public static final int ACTION_DELETE = 3;
	
	public Integer getPrimaryKey();
	public void setPrimaryKey(Integer primaryKey);
	public LocalDateTime getDateCreated();
	public void setDateCreated(LocalDateTime dateCreated);
	public LocalDateTime getDateModified();
	public void setDateModified(LocalDateTime dateModified);
	public int getOptCount();
	public void setOptCount(int optCount);
	
	

	public int getAction();

	public void setAction(int action);
	
	/**
	   * Gets whether this dto has been posted. If <code>true</code>, then it
	   * has been read off the persistence mechanism, or it has been put into
	   * the persistence mechanism; if <code>false</code>, then it is a new
	   * record and has not been persisted.
	   *
	   * @return Whether this dto has been posted
	 */
	 boolean isPersisted();
	 void setPersisted();
}
