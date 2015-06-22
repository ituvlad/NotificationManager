package com.manager.notification.notificationmanager;

import android.annotation.TargetApi;
import android.app.Notification;
import android.app.NotificationManager;
import android.content.Context;
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

    @Override
    public void onNotificationPosted(StatusBarNotification sbn) {
        super.onNotificationPosted(sbn);
        NotificationManager mNotificationManager =
                (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        NotificationCompat.Builder builder = new NotificationCompat.Builder(this);
        builder.setLights(Color.WHITE, 1000, 300);
        Notification notification = builder.build();
        mNotificationManager.notify(sbn.getId(), notification);

        Log.e("!!!!!!!!!!!!!!!!!!!!!!!", "led on: " + notification.ledOnMS);
    }

}
