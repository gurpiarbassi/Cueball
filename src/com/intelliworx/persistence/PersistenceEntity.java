package com.intelliworx.persistence;

import java.io.Serializable;

import org.joda.time.LocalDateTime;

public class PersistenceEntity extends ObjectState implements
		IPersistenceEntity, Serializable, Cloneable {

	private static final long serialVersionUID = 1L;
	private Integer primaryKey;
	private LocalDateTime dateCreated;
	private LocalDateTime dateModified;
	private int optCount;
	private boolean persisted = false;
	private int action;
	
    /**
     * Default constructor
     */
	public PersistenceEntity()
	{
	  super();
	  state = ObjectState.STATE_NEW;
	  setOptCount(0);
	}
	  
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

	public int getNextOptCount() {
		this.optCount = this.optCount + 1;
		return this.optCount;
	}

	public boolean isPersisted() {
		return persisted;
	}

	public void setPersisted() {
		persisted = true;
	}

	public int getAction() {
		return action;
	}

	public void setAction(int action) {
		this.action = action;
	}

	/**
	 * Sets the data transfer modified attribute if the dto has been modified.
	 * 
	 * @param modified
	 *            sets the dto as modified if this is true else does nothing.
	 */
	protected void setModifiedIfTrue(boolean modified) {
		if (modified) {
			setModified();
		}
	}

	/**
	 * Sets this data transfer object as modified if the two objects are
	 * different (as defined by the equals method).
	 * 
	 * @param o1
	 *            the first object (usually the dto attribute).
	 * @param o2
	 *            the second object (usually the change to the attribute).
	 */
	protected void setModified(Object o1, Object o2) {
		if (o1 == null || o2 == null) {
			setModifiedIfTrue(o1 != o2);
		} else {
			setModifiedIfTrue(!o1.equals(o2));
		}
	}

	/**
	 * Sets this data transfer object as modified if the two strings are
	 * different (as defined by the equals method). Not that a null string is
	 * considered equal to an empty string here because an emtpy string written
	 * to the database is returned as a null string next time it is read.
	 * 
	 * @param s1
	 *            the first string (usually the dto attribute).
	 * @param s2
	 *            the second string (usually the change to the attribute).
	 */
	protected void setModified(String s1, String s2) {
		if (s1 == null || s2 == null) {
			if (s1 != s2) {
				if (s1 == null) {
					setModifiedIfTrue(!s2.equals(""));
				} else {
					setModifiedIfTrue(!s1.equals(""));
				}
			}
		} else {
			setModifiedIfTrue(!s1.equals(s2));
		}
	}

	/**
	 * Sets this data transfer object as modified if the two ints are different.
	 * 
	 * @param int1
	 *            the first int (usually the dto attribute).
	 * @param int2
	 *            the second int (usually the change to the attribute);
	 */
	protected void setModified(int int1, int int2) {
		setModifiedIfTrue(int1 != int2);
	}

	/**
	 * Sets this data transfer object as modified if the two longs are
	 * different.
	 * 
	 * @param long1
	 *            the first long (usually the dto attribute).
	 * @param long2
	 *            the second long (usually the change to the attribute);
	 */
	protected void setModified(long long1, long long2) {
		setModifiedIfTrue(long1 != long2);
	}

	/**
	 * Sets this data transfer object as modified if the two floats are
	 * different.
	 * 
	 * @param float1
	 *            the first float (usually the dto attribute).
	 * @param float2
	 *            the second float (usually the change to the attribute);
	 */
	protected void setModified(float float1, float float2) {
		setModifiedIfTrue(float1 != float2);
	}

	/**
	 * Sets this data transfer object as modified if the two doubles are
	 * different.
	 * 
	 * @param double1
	 *            the first double (usually the dto attribute).
	 * @param double2
	 *            the second double (usually the change to the attribute);
	 */
	protected void setModified(double double1, double double2) {
		setModifiedIfTrue(double1 != double2);
	}

	/**
	 * Sets this data transfer object as modified if the two booleans are
	 * different.
	 * 
	 * @param boolean1
	 *            the first boolean (usually the dto attribute).
	 * @param boolean2
	 *            the second boolean (usually the change to the attribute).
	 */
	protected void setModified(boolean boolean1, boolean boolean2) {
		setModifiedIfTrue(boolean1 != boolean2);
	}

	/**
	 * Basic implementation of an equals method that will match the primary key
	 * of similar objects
	 */
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}

		// objects must both be instances of this class
		if (!(obj instanceof PersistenceEntity)) {
			return false;
		}

		// objects must be of the same type
		if (!obj.getClass().getName().equals(this.getClass().getName())) {
			return false;
		}

		// compare the primary keys
		PersistenceEntity other = (PersistenceEntity) obj;
		if (primaryKey == null) {
			if (other.primaryKey != null) {
				return false;
			}
		} else if (!primaryKey.equals(other.primaryKey)) {
			return false;
		}
		return true;
	}

	public Object clone() {
		try {
			return super.clone();
		} catch (CloneNotSupportedException cnse) {
			// won't happen as we get this from IDTO, which extends Cloneable
			return null;
		}
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((primaryKey == null) ? 0 : primaryKey.hashCode());
		return result;
	}

}
