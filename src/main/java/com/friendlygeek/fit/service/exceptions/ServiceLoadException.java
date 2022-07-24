package com.friendlygeek.fit.service.exceptions;

public class ServiceLoadException extends Exception {

	public ServiceLoadException() {
	}

	public ServiceLoadException(String message) {
		super(message);
	}

	public ServiceLoadException(Throwable cause) {
		super(cause);
	}

	public ServiceLoadException(String message, Throwable cause) {
		super(message, cause);
	}

	public ServiceLoadException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

}
