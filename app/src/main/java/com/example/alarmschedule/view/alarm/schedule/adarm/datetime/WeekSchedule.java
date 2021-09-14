package com.example.alarmschedule.view.alarm.schedule.adarm.datetime;

public class WeekSchedule {
    private long id;
    private boolean isActive;
    private Week week;

    public WeekSchedule(boolean isActive, Week week) {
        this.isActive = isActive;
        this.week = week;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    public Week getWeek() {
        return week;
    }

    public void setWeek(Week week) {
        this.week = week;
    }
}
