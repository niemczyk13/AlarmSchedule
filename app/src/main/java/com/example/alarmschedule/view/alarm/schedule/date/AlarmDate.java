package com.example.alarmschedule.view.alarm.schedule.date;

import java.util.Calendar;

public class AlarmDate {
    private Calendar calendar;

    private boolean isAfterNow(Calendar calendar) {
        Calendar now = Calendar.getInstance();
        return calendar.after(now);
    }

    private boolean isAfterNow(int hour, int minute) {


        return false;
    }

    public void setDate(Calendar calendar) {
        this.calendar = calendar;
    }

    public void setTime(int hour, int minute) {
        calendar.set(Calendar.HOUR, hour);
        calendar.set(Calendar.MINUTE, minute);
    }
}
