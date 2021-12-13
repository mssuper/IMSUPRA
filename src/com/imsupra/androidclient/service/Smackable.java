package com.imsupra.androidclient.service;

import com.imsupra.androidclient.exceptions.IMSupraXMPPException;


public interface Smackable {
	boolean doConnect(boolean create_account) throws IMSupraXMPPException;
	boolean isAuthenticated();

	void addRosterItem(String user, String alias, String group) throws IMSupraXMPPException;
	void removeRosterItem(String user) throws IMSupraXMPPException;
	void renameRosterItem(String user, String newName) throws IMSupraXMPPException;
	void moveRosterItemToGroup(String user, String group) throws IMSupraXMPPException;
	void renameRosterGroup(String group, String newGroup);
	void requestAuthorizationForRosterItem(String user);
	void addRosterGroup(String group);
	
	void setStatusFromConfig();
	void sendMessage(String user, String message);
	void sendServerPing();
	
	void registerCallback(XMPPServiceCallback callBack);
	void unRegisterCallback();
	
	String getNameForJID(String jid);
}
