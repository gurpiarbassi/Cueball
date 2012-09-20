package com.intelliworx.persistence;

import java.io.Serializable;

public class ObjectState implements IObjectState, Serializable {

	private static final long serialVersionUID = 1L;
	
	protected int state = STATE_NEW;

	  /**
	   * constructor
	   */
	  public ObjectState()
	  {
	    state = STATE_NEW;
	  }

	  public void setDeleted()
	  {
	    if (this.state != STATE_INVALID)
	    {
	      this.state = STATE_DELETED;
	    }
	  }

	  public boolean isDeleted()
	  {
	    return state == STATE_DELETED;
	  }

	  public void setInvalid()
	  {
	    this.state = STATE_INVALID;
	  }

	  public boolean isInvalid()
	  {
	    return state == STATE_INVALID;
	  }

	  public void setLoaded()
	  {
	    if (this.state == STATE_MODIFIED ||
	        this.state == STATE_NEW)
	    {
	      this.state = STATE_LOADED;
	    }
	  }

	  public boolean isLoaded()
	  {
	    return state == STATE_LOADED;
	  }

	  public void setModified()
	  {
	    if (this.state == STATE_LOADED ||
	        this.state == STATE_DELETED)
	    {
	      this.state = STATE_MODIFIED;
	    }
	  }

	  public boolean isModified()
	  {
	    return state == STATE_MODIFIED;
	  }

	  public void setNew()
	  {
	    this.state = STATE_NEW;
	  }

	  public boolean isNew()
	  {
	    return state == STATE_NEW;
	  }
}
