package com.test.java;

public class BreakNotWorkingException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public BreakNotWorkingException(String message) {
		
		super("Break Not Working: "+message);
	}
}
