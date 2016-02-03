package com.garrettshorr.belesslazy;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

/**
 * Created by gshorr on 2/2/16.
 */
public class ToDoAlarmReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        Intent alarmService = new Intent(context, ToDoAlarmService.class);
        context.startService(alarmService);
    }
}
