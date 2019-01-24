package com.sunil.springData.exception;

public class MenuAppException extends Exception {
	/**
	 * 
	 */
	private static final long serialVersionUID = -7572311597846139381L;

	public MenuAppException(String message, Exception e){
		super(message,e);
	}
	public MenuAppException(String message){
		super(message);
	}
}
