package com.friendlygeek.fit.config;

public class ConfigurationLoadException extends Exception {
	public ConfigurationLoadException() {
	}

	public ConfigurationLoadException(String message) {
		super(message);
	}

	public ConfigurationLoadException(Throwable cause) {
		super(cause);
	}

	public ConfigurationLoadException(String message, Throwable cause) {
		super(message, cause);
	}

	public ConfigurationLoadException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}
}
