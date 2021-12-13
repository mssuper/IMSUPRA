package com.imsupra.androidclient;

import com.imsupra.androidclient.data.IMSupraConfiguration;

import android.app.Application;
import android.content.Context;
import android.preference.PreferenceManager;

import de.duenndns.ssl.MemorizingTrustManager;

public class IMSupraApplication extends Application {
	// identity name and type, see:
	// http://xmpp.org/registrar/disco-categories.html
	public static final String XMPP_IDENTITY_NAME = "imsupra";
	public static final String XMPP_IDENTITY_TYPE = "phone";

	// MTM is needed globally for both the backend (connect)
	// and the frontend (display dialog)
	public MemorizingTrustManager mMTM;

	private IMSupraConfiguration mConfig;

	public IMSupraApplication() {
		super();
	}

	@Override
	public void onCreate() {
		mMTM = new MemorizingTrustManager(this);
		mConfig = new IMSupraConfiguration(PreferenceManager
				.getDefaultSharedPreferences(this));
	}

	public static IMSupraApplication getApp(Context ctx) {
		return (IMSupraApplication)ctx.getApplicationContext();
	}

	public static IMSupraConfiguration getConfig(Context ctx) {
		return getApp(ctx).mConfig;
	}
}

