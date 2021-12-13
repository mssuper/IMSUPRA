package com.imsupra.androidclient.preferences;

import android.os.Bundle;
import android.preference.PreferenceActivity;

import com.imsupra.androidclient.R;
import com.imsupra.androidclient.IMSupraApplication;

public class MainPrefs extends PreferenceActivity{
	public void onCreate(Bundle savedInstanceState) {
		setTheme(IMSupraApplication.getConfig(this).getTheme());
		super.onCreate(savedInstanceState);
		addPreferencesFromResource(R.layout.mainprefs);
	}

}
