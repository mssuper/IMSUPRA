package com.imsupra.androidclient.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.imsupra.androidclient.exceptions.IMSupraXMPPAdressMalformedException;

import android.content.Context;
import android.text.Editable;
import android.util.TypedValue;


public class XMPPHelper {

	public static void verifyJabberID(String jid)
			throws IMSupraXMPPAdressMalformedException {
		if (jid != null) {
			Pattern p = Pattern.compile("(?i)[a-z0-9\\-_\\.]++@[a-z0-9\\-_]++(\\.[a-z0-9\\-_]++)++");
			Matcher m = p.matcher(jid);

			if (!m.matches()) {
				throw new IMSupraXMPPAdressMalformedException("ID Configurado está incorreto!");
			}
		} else {
			throw new IMSupraXMPPAdressMalformedException("ID não foi configurado!");
		}
	}

	public static void verifyJabberID(Editable jid)
			throws IMSupraXMPPAdressMalformedException {
		verifyJabberID(jid.toString());
	}
	
	public static int tryToParseInt(String value, int defVal) {
		int ret;
		try {
			ret = Integer.parseInt(value);
		} catch (NumberFormatException ne) {
			ret = defVal;
		}
		return ret;
	}

	public static int getEditTextColor(Context ctx) {
		TypedValue tv = new TypedValue();
		boolean found = ctx.getTheme().resolveAttribute(android.R.attr.editTextColor, tv, true);
		if (found) {
			// SDK 11+
			return ctx.getResources().getColor(tv.resourceId);
		} else {
			// SDK < 11
			return ctx.getResources().getColor(android.R.color.primary_text_light);
		}
	}
}
