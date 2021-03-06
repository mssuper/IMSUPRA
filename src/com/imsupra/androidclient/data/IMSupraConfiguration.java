package com.imsupra.androidclient.data;

import com.imsupra.androidclient.R;
import com.imsupra.androidclient.exceptions.IMSupraXMPPAdressMalformedException;
import com.imsupra.androidclient.util.PreferenceConstants;
import com.imsupra.androidclient.util.XMPPHelper;

import android.content.SharedPreferences;
import android.content.SharedPreferences.OnSharedPreferenceChangeListener;
import android.net.Uri;
import android.util.Log;

public class IMSupraConfiguration implements OnSharedPreferenceChangeListener {

	private static final String TAG = "imsupra.Configuration";

	private static final String GMAIL_SERVER = "talk.google.com";

	public String password;
	public String ressource;
	public int port;
	public int priority;
	public boolean foregroundService;
	public boolean autoConnect;
	public boolean autoReconnect;
	public boolean messageCarbons;
	public boolean reportCrash;
	public String userName;
	public String server;
	public String customServer;
	public String jabberID;
	public boolean require_ssl;

	public String statusMode;
	public String statusMessage;

	public boolean isLEDNotify;
	public String vibraNotify;
	public Uri notifySound;
	public boolean ticker;

	public boolean smackdebug;
    public String theme;
    public String chatFontSize;

	private final SharedPreferences prefs;

	public IMSupraConfiguration(SharedPreferences _prefs) {
		prefs = _prefs;
		prefs.registerOnSharedPreferenceChangeListener(this);
		loadPrefs(prefs);
	}

	@Override
	protected void finalize() {
		prefs.unregisterOnSharedPreferenceChangeListener(this);
	}

	public void onSharedPreferenceChanged(SharedPreferences prefs, String key) {
		Log.i(TAG, "onSharedPreferenceChanged(): " + key);
		loadPrefs(prefs);
	}

	private void splitAndSetJabberID(String jid) {
		String[] res = jid.split("@");
		this.userName = res[0];
		this.server = res[1];
		// check for gmail.com and other google hosted jabber accounts
		if ("gmail.com".equals(res[1]) || "googlemail.com".equals(res[1])
				|| GMAIL_SERVER.equals(this.customServer)) {
			// work around for gmail's incompatible jabber implementation:
			// send the whole JID as the login, connect to talk.google.com
			this.userName = jid;
			if (this.customServer.length() == 0)
				this.customServer = GMAIL_SERVER;
		}
	}

	private int validatePriority(int jabPriority) {
		if (jabPriority > 127)
			return 127;
		else if (jabPriority < -127)
			return -127;
		return jabPriority;
	}

	private void loadPrefs(SharedPreferences prefs) {
		this.isLEDNotify = prefs.getBoolean(PreferenceConstants.LEDNOTIFY, true);
		this.vibraNotify = prefs.getString(	PreferenceConstants.VIBRATIONNOTIFY, "SYSTEM");
		this.notifySound = Uri.parse(prefs.getString(PreferenceConstants.RINGTONENOTIFY, ""));
		this.ticker = prefs.getBoolean(PreferenceConstants.TICKER,	true);
		this.password = prefs.getString(PreferenceConstants.PASSWORD, "");
		this.ressource = prefs.getString(PreferenceConstants.RESSOURCE, "imsupra");
		this.port = XMPPHelper.tryToParseInt(prefs.getString(
				PreferenceConstants.PORT, PreferenceConstants.DEFAULT_PORT),
				PreferenceConstants.DEFAULT_PORT_INT);
		this.priority = validatePriority(XMPPHelper.tryToParseInt(prefs.getString(PreferenceConstants.PRIORITY, "0"), 0));
		this.foregroundService = prefs.getBoolean(PreferenceConstants.FOREGROUND, true);
		this.autoConnect = prefs.getBoolean(PreferenceConstants.CONN_STARTUP, true);
		this.autoReconnect = prefs.getBoolean(
				PreferenceConstants.AUTO_RECONNECT, true);
		this.messageCarbons = prefs.getBoolean(
				PreferenceConstants.MESSAGE_CARBONS, true);
		this.smackdebug = prefs.getBoolean(PreferenceConstants.SMACKDEBUG,false);
		this.reportCrash = prefs.getBoolean(PreferenceConstants.REPORT_CRASH,false);
		this.jabberID = prefs.getString(PreferenceConstants.JID, "");
		this.customServer = prefs.getString(PreferenceConstants.CUSTOM_SERVER,"");
		this.require_ssl = prefs.getBoolean(PreferenceConstants.REQUIRE_SSL, false);
		this.statusMode = prefs.getString(PreferenceConstants.STATUS_MODE, "available");
		this.statusMessage = prefs.getString(PreferenceConstants.STATUS_MESSAGE, "");
        this.theme = prefs.getString(PreferenceConstants.THEME, "light");
        this.chatFontSize = prefs.getString("setSizeChat", "18");

		try {
			XMPPHelper.verifyJabberID(jabberID);
			splitAndSetJabberID(jabberID);
		} catch (IMSupraXMPPAdressMalformedException e) {
			Log.e(TAG, "Exception in getPreferences(): " + e);
		}
	}


	public int getTheme() {
		if (theme.equals("light")) {
			return R.style.IMSupraLightTheme;
		} else {
			return R.style.IMSupraDarkTheme;
		}
	}
}
