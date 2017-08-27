package com.example.ciccc_cirac.lifecycleproject.notification;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Build;
import android.support.v4.app.NotificationCompat;
import android.support.v4.content.ContextCompat;

import com.example.ciccc_cirac.lifecycleproject.R;

/**
 * Created by saeko on 8/25/2017.
 */

public class NotificationUtils {

    // we can handle notification by  id, after displaying
    private static final int REMINDER_NOTIFICATION_ID = 1138;
    private static final int REMINDER_PENDING_INTENT_ID = 3417;
    private static final String ACTION_DRINK_PENDING_INTENT_ID;

    private static PendingIntent contentIntent(Context context) {
        Intent startActivityIntent = new Intent(context, Notification.class);
        return PendingIntent.getActivity(
                context,
                REMINDER_PENDING_INTENT_ID,
                startActivityIntent,
                PendingIntent.FLAG_UPDATE_CURRENT
        );
    }

    private static Bitmap largeIcon(Context context) {
         //  Get a Resources object from the context.
         Resources res = context.getResources();
         //  Create and return a bitmap using BitmapFactory.decodeResource, passing in the
          // resources object and R.drawable.ic_local_drink_black_24px
         Bitmap largeIcon = BitmapFactory.decodeResource(res, R.mipmap.ic_launcher);
          return largeIcon;
        }

    public static void remindUser(Context context) {
        NotificationCompat.Builder notificationBuilder =
                new NotificationCompat.Builder(context)
                        .setColor(ContextCompat.getColor(context, R.color.colorAccent))
                        .setSmallIcon(R.mipmap.ic_launcher)
                        .setLargeIcon(largeIcon(context))
                        .setContentTitle("I'm here!")
                        .setContentText(context.getString(R.string.content))
                        .setStyle(new NotificationCompat.BigTextStyle().bigText(
                                context.getString(R.string.content)))
                        .setDefaults(Notification.DEFAULT_VIBRATE)
                        .setContentIntent(contentIntent(context))
                        .addAction(drinkWaterAction(context))
                        .addAction(ignoreReminderAction(context))
                        .setAutoCancel(true);
        // if build version is greater than jelly_beans
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN)
        {
            notificationBuilder.setPriority(Notification.PRIORITY_HIGH);
        }
        //get NotificationManager ,using
        //context.getSystemService(Context.NOTIFICATION_SERVICE)
        NotificationManager notificationManager =
                (NotificationManager)context,
                ACTION＿DRINK_PENDING_INTENT_ID,
                drinkWaterIntent,
                PendingTent,FLAG_CANCE_CURRENT

        //Trigger the notification by calling notify
        //on the NotificationManager
        //pass the ID value and build()
        notificationManager.notify(REMINDER_NOTIFICATION_ID,
                notificationBuilder.build());
    }
    // add as a static and type is action
    private static NotificationCompat.Action drinkWaterAction(Context context){
        Intent drinkIntent = new Intent(context, HandleAction.class);
        drinkIntent.setAction(HandleAction.ACTION_DRINK_WATER);
        PendingIntent drinkWaterPI = PendingIntent.getService(context, )
    }
    private static NotificationCompat.Action ignoreReminderAction(Context context) {
        Intent inttent = new Intent(context, HandleAction.class);
    }

    public static void clearAllNotifications(Context context) {
        NotificationManager notificationManager = (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);
        notificationManager.cancelAll();
    }
}
