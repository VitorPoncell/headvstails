package com.poturno.headvstails;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;


public class InstallReferrerReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        String referrer = "";
        Bundle extras = intent.getExtras();
        if (extras != null) {
            referrer = extras.getString("referrer");
        }
        SharedPref.saveReferrer(context, SharedPref.INSTALL_REFERRER_KEY,
                "INSTALL_REFERRER " + referrer);
    }

}
