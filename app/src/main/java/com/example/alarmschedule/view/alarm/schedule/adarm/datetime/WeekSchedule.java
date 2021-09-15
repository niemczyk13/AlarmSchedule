package com.example.alarmschedule.view.alarm.schedule.adarm.datetime;

import java.util.List;

public class WeekSchedule {
    private long id;

    private Week week;

    public WeekSchedule(Week week) {
        this.week = week;
    }

    public boolean isActive() {
        return week.isSchedule();
    }

    public Week getWeek() {
        return week;
    }

    public void setWeek(Week week) {
        this.week = week;
    }

    public List<Boolean> getOnlySelectedDays() {
        return week.getDaysWhenMondayIsFirst();
    }
}
