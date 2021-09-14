package com.example.alarmschedule.view.alarm.schedule.adarm.datetime;

import java.util.Calendar;

public class AlarmDateTime {
    private Calendar dateTime;
    private WeekSchedule weekSchedule;

    public AlarmDateTime(Calendar dateTime, WeekSchedule weekSchedule) {
        this.dateTime = dateTime;
        this.weekSchedule = weekSchedule;
    }

    public Calendar getDateTime() {
        return dateTime;
    }

    public void setDateTime(Calendar dateTime) {
        this.dateTime = dateTime;
    }

    public Week getWeekSchedule() {
        return weekSchedule.getWeek();
    }

    public void setWeekSchedule(Week week) {
        this.weekSchedule.setWeek(week);
    }

    public boolean isSchedule() {
        return weekSchedule.isActive();
    }

    public void setIsSchedule(boolean isSchedule) {
        weekSchedule.setActive(isSchedule);
    }
}
