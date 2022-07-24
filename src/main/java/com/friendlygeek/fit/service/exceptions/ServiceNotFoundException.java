package com.friendlygeek.fit.service.exceptions;

public class ServiceNotFoundException extends Exception {
	private static final long serialVersionUID = -531933204441495818L;

	public ServiceNotFoundException(final String inMessage, final Throwable inNestedException){
		super(inMessage, inNestedException);
	}
}
