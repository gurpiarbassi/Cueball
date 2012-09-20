package com.intelliworx.persistence;

public interface IObjectState {

	public final static int STATE_DELETED = 0;
	public final static int STATE_INVALID = 1;
	public final static int STATE_NEW = 2;
	public final static int STATE_LOADED = 3;
	public final static int STATE_MODIFIED = 4;

	/**
	 * has objected to be deleted
	 * 
	 * @return Whether to be deleted
	 */
	public boolean isDeleted();

	/**
	 * is object invalid
	 * 
	 * @return Whether invalid
	 */
	public boolean isInvalid();

	/**
	 * is object loaded
	 * 
	 * @return Whether loaded
	 */
	public boolean isLoaded();

	/**
	 * is object modified
	 * 
	 * @return Whether modified
	 */
	public boolean isModified();

	/**
	 * is object created
	 * 
	 * @return Whether new
	 */
	public boolean isNew();

	/**
	 * set object as deleted
	 */
	public void setDeleted();

	/**
	 * set object as invalid
	 */
	public void setInvalid();

	/**
	 * set object as loaded
	 */
	public void setLoaded();

	/**
	 * set object as modified
	 */
	public void setModified();

	/**
	 * set object as new
	 */
	public void setNew();

}
