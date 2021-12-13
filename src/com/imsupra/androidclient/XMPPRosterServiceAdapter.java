package com.imsupra.androidclient;


import android.os.RemoteException;
import android.util.Log;
import com.imsupra.androidclient.IXMPPRosterCallback;
import com.imsupra.androidclient.service.IXMPPRosterService;

import com.imsupra.androidclient.util.ConnectionState;

public class XMPPRosterServiceAdapter {
	
	private static final String TAG = "imsupra.XMPPRSAdapter";
	private IXMPPRosterService xmppServiceStub;
	
	public XMPPRosterServiceAdapter(IXMPPRosterService xmppServiceStub) {
		Log.i(TAG, "New XMPPRosterServiceAdapter construced");
		this.xmppServiceStub = xmppServiceStub;
	}
	
	public void setStatusFromConfig() {
		try {
			xmppServiceStub.setStatusFromConfig();
		} catch (RemoteException e) {
			e.printStackTrace();
		}
	}

	public void addRosterItem(String user, String alias, String group) {
		try {
			xmppServiceStub.addRosterItem(user, alias, group);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
	}
	
	public void renameRosterGroup(String group, String newGroup){
		try {
			xmppServiceStub.renameRosterGroup(group, newGroup);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
	}
	
	public void renameRosterItem(String contact, String newItemName){
		try {
			xmppServiceStub.renameRosterItem(contact, newItemName);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
	}
	
	
	public void moveRosterItemToGroup(String user, String group){
		try {
			xmppServiceStub.moveRosterItemToGroup(user, group);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
	}
	
	public void addRosterGroup(String group){
		try {
			xmppServiceStub.addRosterGroup(group);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
	}
	
	public void removeRosterItem(String user) {
		try {
			xmppServiceStub.removeRosterItem(user);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
	}
	
	public void disconnect() {
		try {
			xmppServiceStub.disconnect();
		} catch (RemoteException e) {
			e.printStackTrace();
		}
	}
	
	public void connect() {
		try {
			xmppServiceStub.connect();
		} catch (RemoteException e) {
			e.printStackTrace();
		}
	}

	public void registerUICallback(IXMPPRosterCallback uiCallback) {
		try {
			xmppServiceStub.registerRosterCallback(uiCallback);
		} catch (RemoteException e) {
			e.printStackTrace();
		} catch (NullPointerException e) {
			e.printStackTrace();
		}
	}

	public void unregisterUICallback(IXMPPRosterCallback uiCallback) {
		try {
			xmppServiceStub.unregisterRosterCallback(uiCallback);
		} catch (RemoteException e) {
			e.printStackTrace();
		} catch (NullPointerException e) {
			e.printStackTrace();
		}
	}

	public int getConnectionState() {
		try {
			return xmppServiceStub.getConnectionState();
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return ConnectionState.OFFLINE;
	}

	public String getConnectionStateString() {
		try {
			return xmppServiceStub.getConnectionStateString();
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return null;
	}

	public boolean isAuthenticated() {
		return getConnectionState() == ConnectionState.AUTHENTICATED;
	}

	public void requestAuthorizationForRosterItem(String user) {
		try {
			xmppServiceStub.requestAuthorizationForRosterItem(user);
		} catch (RemoteException e) {
			e.printStackTrace();
		} catch (NullPointerException e) {
			e.printStackTrace();
		}
	}

}
