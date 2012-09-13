package com.intelliworx.inf.exception;

import org.springframework.dao.DataAccessException;

public class PersistenceException extends DataAccessException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public PersistenceException(String msg) {
		super(msg);
	}
	
	public PersistenceException(String msg, Throwable cause) {
		super(msg, cause);
	}
	
	

	

}
