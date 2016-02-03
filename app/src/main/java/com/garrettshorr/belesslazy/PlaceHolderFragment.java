package com.garrettshorr.belesslazy;

import android.app.Activity;
import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.Switch;

import java.util.Calendar;
import java.util.Date;

/**
 * Created by gshorr on 1/27/16.
 */
public class PlaceHolderFragment extends Fragment {

    private Switch mAlarmSwitch;
    private PendingIntent mAlarmPendingIntent;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_placeholder, container, false);

        //Alarm Section
        final Activity thisActivity = getActivity();
        final int ALARM_DELAY = 10;
        final Calendar calendar = Calendar.getInstance();


        final Intent alarmIntent = new Intent(thisActivity, ToDoAlarmReceiver.class);
        //mAlarmPendingIntent = PendingIntent.getBroadcast(getActivity(), 0, alarmIntent, 0);

        final AlarmManager alarmManager = (AlarmManager)thisActivity.
                                        getSystemService(thisActivity.ALARM_SERVICE);


        //Alarm Switch to turn on & off the alarm
        mAlarmSwitch = (Switch) rootView.findViewById(R.id.alarm_switch);
        mAlarmSwitch.setChecked(false);
        mAlarmSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked) {
                    calendar.setTime(new Date());
                    calendar.set(Calendar.SECOND, calendar.get(Calendar.SECOND) + ALARM_DELAY);
                    mAlarmPendingIntent = PendingIntent.getBroadcast(getActivity(), 0, alarmIntent, 0);
                    alarmManager.set(AlarmManager.RTC, calendar.getTimeInMillis(),
                            mAlarmPendingIntent);
                }
                else
                    alarmManager.cancel(mAlarmPendingIntent);
            }
        });

        return rootView;
    }
}