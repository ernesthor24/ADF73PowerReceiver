package com.example.adf73powerreceiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

public class CustomReceiver extends BroadcastReceiver {

    private static final String ACTION_CUSTOM_BROADCAST =
            BuildConfig.APPLICATION_ID + ".ACTION_CUSTOM_BROADCAST";

    @Override
    public void onReceive(Context context, Intent intent) {
        String intentAction = intent.getAction();

        if(intentAction != null) {
            String toastMessage = context.getString(R.string.unknown_intent);

            switch (intentAction) {
                case Intent.ACTION_POWER_CONNECTED:
                    toastMessage = context.getString(R.string.power_con);
                    break;
                case Intent.ACTION_POWER_DISCONNECTED:
                    toastMessage = context.getString(R.string.power_disc);
                    break;

                case ACTION_CUSTOM_BROADCAST:
                    toastMessage = context.getString(R.string.custom_intent);
                    break;
            }
            Toast.makeText(context, toastMessage, Toast.LENGTH_SHORT).show();
        }
    }
}
