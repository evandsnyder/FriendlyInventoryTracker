package com.friendlygeek.fit.service.exceptions;

public class PropertyFileLoadException extends Exception {

	public PropertyFileLoadException() {
	}

	public PropertyFileLoadException(String message) {
		super(message);
	}

	public PropertyFileLoadException(Throwable cause) {
		super(cause);
	}

	public PropertyFileLoadException(String message, Throwable cause) {
		super(message, cause);
	}

	public PropertyFileLoadException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

}
