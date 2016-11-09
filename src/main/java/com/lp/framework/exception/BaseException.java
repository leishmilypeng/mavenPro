package com.lp.framework.exception;

public class BaseException extends Exception {

    public BaseException(String msg) {
		super(msg);
	}
    
	public BaseException(Throwable t) {
		super(t);
	}
	
}
