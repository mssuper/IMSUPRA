package com.imsupra.androidclient.service;

public interface XMPPServiceCallback {
	void newMessage(String from, String messageBody);
	void rosterChanged();
	void disconnectOnError();
}
