package com.example.ciccc_cirac.lifecycleproject.broadcast;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.widget.Toast;

/**
 * Created by saeko on 8/11/2017.
 */

public class BroadcastReceiveDemo extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        if (intent.getAction().equals("com.example.ciccc_cirac.lifecycleproject.broadcast.SOME_ACTION")) {
            Toast.makeText(context,"SOME_ACTIOM is received", Toast.LENGTH_LONG).show();
        } else {
            ConnectivityManager cm = (ConnectivityManager)
                    context.getSystemService(Context.CONNECTIVITY_SERVICE);
            NetworkInfo activeNetwork =
                    cm.getActiveNetworkInfo();
            boolean isConnected = activeNetwork!= null
                    && activeNetwork.isConnectedOrConnecting();
            if(isConnected) {
                Toast.makeText(context,"NETWORK IS CONNECTED",
                        Toast.LENGTH_LONG).show();

            } else {
                Toast.makeText(context,"NETWORK IS CHANGED or DISCONNCTED",
                        Toast.LENGTH_LONG).show();
            }
        }
    }
}
