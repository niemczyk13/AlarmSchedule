package com.example.alarmschedule.view.alarm.schedule.date;

import java.util.Calendar;

public class AlarmDateTimeLogic {
    private Calendar dateTime;

    public AlarmDateTimeLogic(Calendar calendar) {
        this.dateTime = calendar;
    }

    private boolean isAfterNow(Calendar calendar) {
        Calendar now = Calendar.getInstance();
        return calendar.after(now);
    }

    private boolean isAfterNow(int hour, int minute) {


        return false;
    }

    public void setDate(Calendar calendar) {
        this.dateTime = calendar;
    }

    public void setTime(int hour, int minute) {
        dateTime.set(Calendar.HOUR, hour);
        dateTime.set(Calendar.MINUTE, minute);
    }

    public Calendar getDateTime() {
        return dateTime;
    }
}
