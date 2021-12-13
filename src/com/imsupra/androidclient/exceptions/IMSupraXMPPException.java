package com.imsupra.androidclient.exceptions;

public class IMSupraXMPPException extends Exception {
	
	private static final long serialVersionUID = 1L;

	public IMSupraXMPPException(String message) {
		super(message);
	}

	public IMSupraXMPPException(String message, Throwable cause) {
		super(message, cause);
	}
}
