package com.garrettshorr.belesslazy;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Intent;
import android.os.IBinder;

/**
 * Created by gshorr on 2/2/16.
 */
public class ToDoAlarmService extends Service {

    private NotificationManager mManager;

    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        super.onStartCommand(intent, flags, startId);

        mManager = (NotificationManager) this.getApplicationContext().
                    getSystemService(this.getApplicationContext().NOTIFICATION_SERVICE);
        Intent intent1 = new Intent(this.getApplicationContext(),MainActivity.class);


        PendingIntent pendingNotificationIntent = PendingIntent.getActivity(
                this.getApplicationContext(),0, intent1,PendingIntent.FLAG_UPDATE_CURRENT);

        Notification notification = new Notification.Builder(this)
                .setContentTitle("(╯°□°）╯︵ ┻━┻")
                .setContentText("Oooh, nifty Alarm you have there.")
                .setSmallIcon(android.R.drawable.btn_star)
                .setWhen(System.currentTimeMillis())
                .setContentIntent(pendingNotificationIntent)
                .setTicker("(╯°□°）╯︵ ┻━┻") //deprecated in L
                .setAutoCancel(true)
                .setPriority(Notification.PRIORITY_HIGH)
                .setDefaults(Notification.DEFAULT_SOUND)
                .build();

        intent1.addFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP | Intent.FLAG_ACTIVITY_CLEAR_TOP);

        notification.flags |= Notification.FLAG_AUTO_CANCEL;


        mManager.notify(0, notification);


        return START_STICKY;
    }

    @Override
    public void onCreate() {
        super.onCreate();
    }
}
