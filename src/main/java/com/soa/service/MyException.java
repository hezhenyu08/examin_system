package com.soa.service;
/**
 * 自定义异常类
 * @author hezy
 *
 */
public class MyException extends Exception {
	private static final long serialVersionUID = -4569055952193862970L;

	public MyException() {
		super();
	}

	public MyException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public MyException(String message, Throwable cause) {
		super(message, cause);
	}

	public MyException(String message) {
		super(message);
	}

	public MyException(Throwable cause) {
		super(cause);
	}

}
