package com.example.ciccc_cirac.lifecycleproject.notification;

import android.content.Context;

/**
 * Created by saeko on 8/25/2017.
 */

public class HandleAction {
    public static final String ACTION_DRINK_WATER = "drink";
    public static final String ACTION_IGNORE = "dismiss";

    public void executeTask(Context context, String action) {
        if (ACTION_DRINK_WATER.equals(action)) {
            NotificationUtils.clearAllNotifications(context);
        } else if (ACTION_IGNORE.equals(action)) {
            NotificationUtils.clearAllNotifications(context);
        } else {

        }
    }

}
