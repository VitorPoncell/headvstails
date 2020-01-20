package com.poturno.headvstails;

import android.content.Context;
import android.content.SharedPreferences;

public class SharedPref {

    public static final String SHARED_PREF_FILE = "MyPreference";
    public static final String INSTALL_REFERRER_KEY = "InstallReferrer";
    public static final String MAIN_ACTIVITY_KEY = "MainActivity";

    public static void saveReferrer(Context context, String key, String referrer) {
        SharedPreferences preferences =
                context.getApplicationContext().getSharedPreferences(SHARED_PREF_FILE, 0);
        SharedPreferences.Editor editor = preferences.edit();
        editor.putString(key, referrer);
        editor.commit();
    }
}
