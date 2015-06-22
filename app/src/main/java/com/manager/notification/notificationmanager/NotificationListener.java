package com.manager.notification.notificationmanager;

import android.annotation.TargetApi;
import android.app.Notification;
import android.app.NotificationManager;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.os.Build;
import android.service.notification.NotificationListenerService;
import android.service.notification.StatusBarNotification;
import android.support.v4.app.NotificationCompat;
import android.util.Log;

/**
 * Created by Vlad on 19-Jun-15.
 */
@TargetApi(Build.VERSION_CODES.JELLY_BEAN_MR2)
public class NotificationListener extends NotificationListenerService {

    private int handledId;

    @Override
    public void onNotificationPosted(StatusBarNotification sbn) {
        super.onNotificationPosted(sbn);
        if(sbn.getId() != handledId ) {
            NotificationManager mNotificationManager =
                    (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
            Notification.Builder builder = new Notification.Builder(this);
            builder.setPriority(Notification.PRIORITY_MAX);
            builder.setDefaults(Notification.DEFAULT_LIGHTS);
            //builder.setLights(Color.WHITE, 1, 1);
            builder.setSmallIcon(R.drawable.ic_money_bag);
            Notification notification = builder.build();
            notification.ledARGB = Color.WHITE;
            notification.ledOnMS = 500;
            notification.ledOffMS = 500;
            mNotificationManager.notify(sbn.getId(), notification);

            Log.e("!!!!!!!!!!!!!!!!!!!!!!!", "led on: " + notification.ledOnMS);
            handledId = sbn.getId();
        }
    }

    @Override
    public void onNotificationRemoved(StatusBarNotification sbn) {
        super.onNotificationRemoved(sbn);
    }
}

